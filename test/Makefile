TESTS=	InterfaceTest AbstractClassTest AnonymousClassTest \
	SerializableTest TypeswitchTest

all:	$(TESTS)

InterfaceTest: sanka/InterfaceTest.san
	sanka --top bin $< --exe $@ --main sanka.test.$@
	./$@

AbstractClassTest: sanka/AbstractClassTest.san
	sanka --top bin $< --exe $@ --main sanka.test.$@
	./$@

AnonymousClassTest: sanka/AnonymousClassTest.san
	sanka --top bin $< --exe $@ --main sanka.test.$@
	./$@

SerializableTest: sanka/SerializableTest.san
	sanka --top bin $< --exe $@ --main sanka.test.$@
	./$@

TypeswitchTest: sanka/TypeswitchTest.san
	sanka --top bin $< --exe $@ --main sanka.test.$@
	./$@

clean: .DUMMY
	rm -rf $(TESTS) bin

.DUMMY:
