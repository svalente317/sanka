package sanka.c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;

import sanka.ClassDefinition;
import sanka.ClassWriter;
import sanka.Environment;

public class LibraryManager {

    private static final String C_LIB_NAME = "lib.a";
    private List<File> tmpDirectories = new ArrayList<>();

    /**
     * Create a library with everything necessary to use the compiled Sanka classes as imports.
     * We need to be able to compile from Sanka to C, and from C to object code, and link
     * the object code. We do not need the uncompiled Sanka or C code.
     *
     * Should the library contain a Manifest file? It would be nice, but it's not immediately
     * necessary.
     */
    public void createLibrary(String filename, CompileManager compileManager) throws Exception {
        Environment env = Environment.getInstance();
        File tmpfile = File.createTempFile("san", ".tmp");
        tmpfile.delete();
        List<String> arCommand = new ArrayList<>();
        arCommand.add("ar");
        arCommand.add("cqs");
        arCommand.add(tmpfile.toString());
        for (ClassDefinition classdef : env.classList) {
            if (classdef.isImport) {
                continue;
            }
            File cfile = ClassTranslator.getClassFilename(classdef, false);
            compileManager.compileFile(cfile.getPath(), arCommand);
        }
        if (env.errorCount > 0) {
            return;
        }

        // Create the lib.a file containing the .o files.
        // This will be used by gcc to link executables using this library.
        int status = compileManager.executeCommand(arCommand);
        if (status != 0) {
            env.printError(null, "ar command exited with status " + status);
        }

        // Create the [name].tar file with everything that sanka needs to use this library.
        // This includes sanka headers, C headers, and object files.
        TarArchiveOutputStream tarStream =
                new TarArchiveOutputStream(new FileOutputStream(filename));

        // Include lib.a in the library.
        tarStream.putArchiveEntry(tarStream.createArchiveEntry(tmpfile, C_LIB_NAME));
        InputStream istream = new FileInputStream(tmpfile);
        IOUtils.copy(istream, tarStream);
        istream.close();
        tarStream.closeArchiveEntry();

        // Include skeleton .san files for all classes in the library.
        for (ClassDefinition classdef : env.classList) {
            if (classdef.isImport || classdef.isAnonymous) {
                continue;
            }
            ClassWriter.writeFile(classdef, tmpfile);
            String name = ClassTranslator.getSankaImportFileName(classdef);
            tarStream.putArchiveEntry(tarStream.createArchiveEntry(tmpfile, name));
            istream = new FileInputStream(tmpfile);
            IOUtils.copy(istream, tarStream);
            istream.close();
            tarStream.closeArchiveEntry();
        }

        // Include all .h files in the library.
        for (ClassDefinition classdef : env.classList) {
            if (classdef.isImport || classdef.isAnonymous) {
                continue;
            }
            File hfile = ClassTranslator.getClassFilename(classdef, true);
            String name = ClassTranslator.getHeaderFileName(classdef.packageName, classdef.name);
            tarStream.putArchiveEntry(tarStream.createArchiveEntry(hfile, name));
            istream = new FileInputStream(hfile);
            IOUtils.copy(istream, tarStream);
            istream.close();
            tarStream.closeArchiveEntry();
        }
        tarStream.close();
        tmpfile.delete();
    }

    /**
     * Unpack library so we can compile Sanka and C files.
     */
    public void unpackLibrary(String filename, CompileManager compileManager) throws IOException {
        Environment env = Environment.getInstance();
        File library = findLibrary(filename);
        File tmpdir = Files.createTempDirectory("sanka").toFile();
        this.tmpDirectories.add(tmpdir);
        TarArchiveInputStream tarStream = new TarArchiveInputStream(new FileInputStream(library));

        for (TarArchiveEntry tarEntry = tarStream.getNextTarEntry();
                tarEntry != null; tarEntry = tarStream.getNextTarEntry()) {
            File destFile = new File(tmpdir, tarEntry.getName());
            if (tarEntry.isDirectory()) {
                destFile.mkdirs();
            } else {
                destFile.getParentFile().mkdirs();
                OutputStream ostream = new FileOutputStream(destFile);
                IOUtils.copy(tarStream, ostream);
                ostream.close();
            }
        }
        tarStream.close();

        env.addImportPath(tmpdir.toString());
        File olib = new File(tmpdir, C_LIB_NAME);
        compileManager.addCLibrary(olib.toString());
    }

    private File findLibrary(String filename) {
        Environment env = Environment.getInstance();
        File file = new File(filename);
        if (file.exists()) {
            return file;
        }
        for (String directory : env.libPath) {
            file = new File(directory, filename);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    public void cleanup() {
        for (File directory : this.tmpDirectories) {
            deleteDirectory(directory);
        }
    }

    private boolean deleteDirectory(File directory) {
        File[] contents = directory.listFiles();
        if (contents != null) {
            for (File file : contents) {
                deleteDirectory(file);
            }
        }
        return directory.delete();
    }
}
