package com.workert.robotics.base.roboscriptbytecode.tool;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class OpCodeGenerator {
	// tool i made to make it less of a pain to add opcodes
	private static List<String> opCodes = new ArrayList<>();
	private static final String path = "src/main/java/com/workert/robotics/base/roboscriptbytecode/OpCode.java";

	private static void defineOpCodes() {
		opCodes.add("OP_CONSTANT");
		opCodes.add("OP_NULL");
		opCodes.add("OP_TRUE");
		opCodes.add("OP_FALSE");
		opCodes.add("OP_POP");
		opCodes.add("OP_GET_LOCAL");
		opCodes.add("OP_SET_LOCAL");
		opCodes.add("OP_GET_GLOBAL");
		opCodes.add("OP_DEFINE_GLOBAL");
		opCodes.add("OP_SET_GLOBAL");
		opCodes.add("OP_EQUAL");
		opCodes.add("OP_NOT_EQUAL");
		opCodes.add("OP_GREATER");
		opCodes.add("OP_GREATER_EQUAL");
		opCodes.add("OP_LESS");
		opCodes.add("OP_LESS_EQUAL");
		opCodes.add("OP_ADD");
		opCodes.add("OP_INCREMENT_GLOBAL");
		opCodes.add("OP_INCREMENT_LOCAL");
		opCodes.add("OP_INCREMENT_MAP");
		opCodes.add("OP_SUBTRACT");
		opCodes.add("OP_DECREMENT_GLOBAL");
		opCodes.add("OP_DECREMENT_LOCAL");
		opCodes.add("OP_DECREMENT_MAP");
		opCodes.add("OP_MULTIPLY");
		opCodes.add("OP_DIVIDE");
		opCodes.add("OP_MODULO");
		opCodes.add("OP_POWER");
		opCodes.add("OP_NOT");
		opCodes.add("OP_NEGATE");
		opCodes.add("OP_JUMP");
		opCodes.add("OP_JUMP_IF_FALSE");
		opCodes.add("OP_LOOP");
		opCodes.add("OP_CALL");
		opCodes.add("OP_GET_NATIVE");
		opCodes.add("OP_RETURN");
		// classes are also maps
		opCodes.add("OP_MAKE_MAP");
		opCodes.add("OP_MAKE_LIST");
		// lists are also maps but just here
		opCodes.add("OP_MAP_GET");
		opCodes.add("OP_MAP_SET");
		opCodes.add("OP_END");
	}


	public static void main(String[] args) throws IOException {
		defineOpCodes();
		PrintWriter writer = new PrintWriter(path, "UTF-8");
		writer.println("package com.workert.robotics.base.roboscriptbytecode;");
		writer.println();
		writer.println("public interface OpCode {");
		for (int i = 0; i < opCodes.size(); i++) {
			writer.println("    byte " + opCodes.get(i) + " = " + i + ";");
		}
		writer.println("}");
		writer.close();
	}
}
