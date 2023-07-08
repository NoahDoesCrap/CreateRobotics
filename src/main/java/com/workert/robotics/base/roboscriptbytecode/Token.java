package com.workert.robotics.base.roboscriptbytecode;
import static com.workert.robotics.base.roboscriptbytecode.Compiler.Precedence.*;

final class Token {
	final TokenType type;
	final String lexeme;
	final int line;

	Token(TokenType type, String lexeme, int line) {
		this.type = type;
		this.lexeme = lexeme;
		this.line = line;
	}

	public enum TokenType {
		// Single-character tokens.
		LEFT_PAREN(new Compiler.ParseRule(Compiler::grouping, null, NONE)),
		RIGHT_PAREN(empty()),
		LEFT_BRACE(empty()),
		RIGHT_BRACE(empty()),
		LEFT_BRACKET(empty()),
		RIGHT_BRACKET(empty()),
		COMMA(empty()),
		DOT(empty()),
		PLUS(new Compiler.ParseRule(null, Compiler::binary, TERM)),
		MINUS(new Compiler.ParseRule(Compiler::unary, Compiler::binary, TERM)),
		STAR(new Compiler.ParseRule(null, Compiler::binary, FACTOR)),
		SLASH(new Compiler.ParseRule(null, Compiler::binary, FACTOR)),

		// these two need to be changed when i figure out where they are actually supposed to go in the order of operations
		PERCENT(new Compiler.ParseRule(null, Compiler::binary, FACTOR)),
		CARET(new Compiler.ParseRule(null, Compiler::binary, FACTOR)),

		COLON(empty()),
		SEMICOLON(empty()),

		// One or two character tokens.
		BANG(new Compiler.ParseRule(Compiler::unary, null, NONE)),
		BANG_EQUAL(empty()),
		EQUAL(empty()),
		EQUAL_EQUAL(empty()),
		PLUS_EQUAL(empty()),
		PLUS_PLUS(empty()),
		MINUS_EQUAL(empty()),
		MINUS_MINUS(empty()),
		STAR_EQUAL(empty()),
		SLASH_EQUAL(empty()),
		CARET_EQUAL(empty()),
		GREATER(empty()),
		GREATER_EQUAL(empty()),
		LESS(empty()),
		LESS_EQUAL(empty()),

		// Literals.
		IDENTIFIER(empty()),
		STRING_VALUE(empty()),
		DOUBLE_VALUE(new Compiler.ParseRule(Compiler::number, null, NONE)),

		// Keywords.
		CLASS(empty()),
		FUNCTION(empty()),

		FOR(empty()),
		FOREACH(empty()),

		IF(empty()),
		ELSE(empty()),
		WHILE(empty()),

		TRUE(new Compiler.ParseRule(Compiler::literal, null, NONE)),
		FALSE(empty()),

		AND(empty()),
		OR(empty()),

		NULL(empty()),


		EXTENDS(empty()),
		SUPER(empty()),
		THIS(empty()),
		RETURN(empty()),
		BREAK(empty()),
		VAR(empty()),

		PERSISTENT(empty()),
		INSTANCEOF(empty()),

		STRING(empty()),
		DOUBLE(empty()),
		BOOLEAN(empty()),
		ARRAY(empty()),
		OBJECT(empty()),


		EOF(empty()),
		ERROR(empty());

		private final Compiler.ParseRule parseRule;

		TokenType(Compiler.ParseRule rule) {
			this.parseRule = rule;
		}

		public Compiler.ParseRule getParseRule() {
			return this.parseRule;
		}
	}

	@Override
	public String toString() {
		return "Token: " + this.type + ' ' + '"' + this.lexeme + '"';
	}


	private static Compiler.ParseRule empty() {
		return new Compiler.ParseRule(null, null, NONE);
	}

}