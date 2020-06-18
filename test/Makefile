all:	AbstractClassTest SerializableTest TypeswitchTest

AbstractClassTest: sanka/AbstractClassTest.san
	sanka --top bin $< --exe $@ --main sanka.test.$@
	./$@

SerializableTest: sanka/SerializableTest.san
	sanka --top bin $< --exe $@ --main sanka.test.$@
	./$@

TypeswitchTest: sanka/TypeswitchTest.san
	sanka --top bin $< --exe $@ --main sanka.test.$@
	./$@

clean: .DUMMY
	rm -rf AbstractClassTest SerializableTest TypeswitchTest bin

.DUMMY:
