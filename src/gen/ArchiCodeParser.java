// Generated from C:/Users/szyro/IdeaProjects/pz1/ArchiCode/ArchiCode.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ArchiCodeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, VarName=48, CapitalVarName=49, INT=50, FLOAT=51, CHAR=52, 
		STRING=53, INLINE_COMMENT=54, LINE_COMMENT=55, MULTILINE_COMMENT=56, WS=57;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_coreStatement = 2, RULE_showStatement = 3, 
		RULE_defineStatement = 4, RULE_defineCollectionStatement = 5, RULE_assignStatement = 6, 
		RULE_requestStatement = 7, RULE_blueprintStatement = 8, RULE_blueprintCallStatement = 9, 
		RULE_paramList = 10, RULE_param = 11, RULE_repeatStatement = 12, RULE_checkStatement = 13, 
		RULE_block = 14, RULE_expr = 15, RULE_orExpr = 16, RULE_andExpr = 17, 
		RULE_equalityExpr = 18, RULE_relationalExpr = 19, RULE_addSubExpr = 20, 
		RULE_mulDivExpr = 21, RULE_unaryExpr = 22, RULE_atom = 23, RULE_exprList = 24, 
		RULE_type = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "coreStatement", "showStatement", "defineStatement", 
			"defineCollectionStatement", "assignStatement", "requestStatement", "blueprintStatement", 
			"blueprintCallStatement", "paramList", "param", "repeatStatement", "checkStatement", 
			"block", "expr", "orExpr", "andExpr", "equalityExpr", "relationalExpr", 
			"addSubExpr", "mulDivExpr", "unaryExpr", "atom", "exprList", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Core'", "'('", "')'", "'delivers'", "'show'", "'define'", "'='", 
			"'box'", "'chain'", "'catalog'", "'['", "']'", "'request'", "'blueprint'", 
			"';'", "','", "'repeat'", "'until'", "'for'", "'in'", "'check'", "'then'", 
			"'otherwise'", "'{'", "'}'", "'or'", "'and'", "'=='", "'!='", "'<'", 
			"'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'not'", "'true'", 
			"'false'", "'step'", "'@'", "'int'", "'float'", "'bool'", "'char'", "'string'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"VarName", "CapitalVarName", "INT", "FLOAT", "CHAR", "STRING", "INLINE_COMMENT", 
			"LINE_COMMENT", "MULTILINE_COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ArchiCode.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArchiCodeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ArchiCodeParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				statement();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 844424932384866L) != 0) );
			setState(57);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public ShowStatementContext showStatement() {
			return getRuleContext(ShowStatementContext.class,0);
		}
		public DefineStatementContext defineStatement() {
			return getRuleContext(DefineStatementContext.class,0);
		}
		public DefineCollectionStatementContext defineCollectionStatement() {
			return getRuleContext(DefineCollectionStatementContext.class,0);
		}
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public RequestStatementContext requestStatement() {
			return getRuleContext(RequestStatementContext.class,0);
		}
		public RepeatStatementContext repeatStatement() {
			return getRuleContext(RepeatStatementContext.class,0);
		}
		public CheckStatementContext checkStatement() {
			return getRuleContext(CheckStatementContext.class,0);
		}
		public BlueprintStatementContext blueprintStatement() {
			return getRuleContext(BlueprintStatementContext.class,0);
		}
		public BlueprintCallStatementContext blueprintCallStatement() {
			return getRuleContext(BlueprintCallStatementContext.class,0);
		}
		public CoreStatementContext coreStatement() {
			return getRuleContext(CoreStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				showStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				defineStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				defineCollectionStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				assignStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				requestStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				repeatStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(65);
				checkStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(66);
				blueprintStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(67);
				blueprintCallStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(68);
				coreStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CoreStatementContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VarName() { return getToken(ArchiCodeParser.VarName, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public CoreStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coreStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterCoreStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitCoreStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitCoreStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoreStatementContext coreStatement() throws RecognitionException {
		CoreStatementContext _localctx = new CoreStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_coreStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__0);
			setState(72);
			match(T__1);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 554153860399104L) != 0)) {
				{
				setState(73);
				paramList();
				}
			}

			setState(76);
			match(T__2);
			setState(77);
			match(T__3);
			setState(78);
			type();
			setState(79);
			match(VarName);
			setState(80);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShowStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ShowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterShowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitShowStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitShowStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowStatementContext showStatement() throws RecognitionException {
		ShowStatementContext _localctx = new ShowStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_showStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__4);
			setState(83);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefineStatementContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(ArchiCodeParser.VarName, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DefineStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterDefineStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitDefineStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitDefineStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineStatementContext defineStatement() throws RecognitionException {
		DefineStatementContext _localctx = new DefineStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_defineStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__5);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 272678883688448L) != 0)) {
				{
				setState(86);
				type();
				}
			}

			setState(89);
			match(VarName);
			setState(90);
			match(T__6);
			setState(91);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefineCollectionStatementContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VarName() { return getToken(ArchiCodeParser.VarName, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DefineCollectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineCollectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterDefineCollectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitDefineCollectionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitDefineCollectionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineCollectionStatementContext defineCollectionStatement() throws RecognitionException {
		DefineCollectionStatementContext _localctx = new DefineCollectionStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defineCollectionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__5);
			setState(94);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(95);
			type();
			setState(96);
			match(VarName);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(97);
				match(T__10);
				setState(98);
				expr();
				setState(99);
				match(T__11);
				}
			}

			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(103);
				match(T__6);
				setState(104);
				expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignStatementContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(ArchiCodeParser.VarName, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterAssignStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitAssignStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitAssignStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStatementContext assignStatement() throws RecognitionException {
		AssignStatementContext _localctx = new AssignStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(VarName);
			setState(108);
			match(T__6);
			setState(109);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RequestStatementContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(ArchiCodeParser.VarName, 0); }
		public RequestStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requestStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterRequestStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitRequestStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitRequestStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RequestStatementContext requestStatement() throws RecognitionException {
		RequestStatementContext _localctx = new RequestStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_requestStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__12);
			setState(112);
			match(VarName);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlueprintStatementContext extends ParserRuleContext {
		public TerminalNode CapitalVarName() { return getToken(ArchiCodeParser.CapitalVarName, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VarName() { return getToken(ArchiCodeParser.VarName, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlueprintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blueprintStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterBlueprintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitBlueprintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitBlueprintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlueprintStatementContext blueprintStatement() throws RecognitionException {
		BlueprintStatementContext _localctx = new BlueprintStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_blueprintStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__13);
			setState(115);
			match(CapitalVarName);
			setState(116);
			match(T__1);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 554153860399104L) != 0)) {
				{
				setState(117);
				paramList();
				}
			}

			setState(120);
			match(T__2);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(121);
				match(T__3);
				setState(122);
				type();
				setState(123);
				match(VarName);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(124);
					match(T__6);
					setState(125);
					expr();
					}
				}

				}
			}

			setState(130);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlueprintCallStatementContext extends ParserRuleContext {
		public TerminalNode CapitalVarName() { return getToken(ArchiCodeParser.CapitalVarName, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlueprintCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blueprintCallStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterBlueprintCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitBlueprintCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitBlueprintCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlueprintCallStatementContext blueprintCallStatement() throws RecognitionException {
		BlueprintCallStatementContext _localctx = new BlueprintCallStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_blueprintCallStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(CapitalVarName);
			setState(134); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(133);
					expr();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(136); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(138);
				match(T__14);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			param();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(142);
				match(T__15);
				setState(143);
				param();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(ArchiCodeParser.VarName, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 272678883688448L) != 0)) {
				{
				setState(149);
				type();
				}
			}

			setState(152);
			match(VarName);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RepeatStatementContext extends ParserRuleContext {
		public RepeatStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatStatement; }
	 
		public RepeatStatementContext() { }
		public void copyFrom(RepeatStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepeatFixedContext extends RepeatStatementContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RepeatFixedContext(RepeatStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterRepeatFixed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitRepeatFixed(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitRepeatFixed(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepeatUntilContext extends RepeatStatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RepeatUntilContext(RepeatStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterRepeatUntil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitRepeatUntil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitRepeatUntil(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepeatForContext extends RepeatStatementContext {
		public List<TerminalNode> VarName() { return getTokens(ArchiCodeParser.VarName); }
		public TerminalNode VarName(int i) {
			return getToken(ArchiCodeParser.VarName, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RepeatForContext(RepeatStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterRepeatFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitRepeatFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitRepeatFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatStatementContext repeatStatement() throws RecognitionException {
		RepeatStatementContext _localctx = new RepeatStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_repeatStatement);
		int _la;
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new RepeatFixedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(T__16);
				setState(155);
				expr();
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17737098240983044L) != 0)) {
					{
					setState(156);
					expr();
					}
				}

				setState(159);
				block();
				}
				break;
			case 2:
				_localctx = new RepeatUntilContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(T__16);
				setState(162);
				match(T__17);
				setState(163);
				expr();
				setState(164);
				block();
				}
				break;
			case 3:
				_localctx = new RepeatForContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				match(T__16);
				setState(167);
				match(T__18);
				setState(168);
				match(VarName);
				setState(169);
				match(T__19);
				setState(170);
				match(VarName);
				setState(171);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CheckStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public CheckStatementContext checkStatement() {
			return getRuleContext(CheckStatementContext.class,0);
		}
		public CheckStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterCheckStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitCheckStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitCheckStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CheckStatementContext checkStatement() throws RecognitionException {
		CheckStatementContext _localctx = new CheckStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_checkStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__20);
			setState(175);
			expr();
			setState(176);
			match(T__21);
			setState(177);
			block();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(178);
				match(T__22);
				setState(181);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__20:
					{
					setState(179);
					checkStatement();
					}
					break;
				case T__23:
					{
					setState(180);
					block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__23);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 844424932384866L) != 0)) {
				{
				{
				setState(186);
				statement();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			orExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ParserRuleContext {
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_orExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			andExpr();
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(197);
					match(T__25);
					setState(198);
					andExpr();
					}
					} 
				}
				setState(203);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ParserRuleContext {
		public List<EqualityExprContext> equalityExpr() {
			return getRuleContexts(EqualityExprContext.class);
		}
		public EqualityExprContext equalityExpr(int i) {
			return getRuleContext(EqualityExprContext.class,i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_andExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			equalityExpr();
			setState(209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(205);
					match(T__26);
					setState(206);
					equalityExpr();
					}
					} 
				}
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExprContext extends ParserRuleContext {
		public List<RelationalExprContext> relationalExpr() {
			return getRuleContexts(RelationalExprContext.class);
		}
		public RelationalExprContext relationalExpr(int i) {
			return getRuleContext(RelationalExprContext.class,i);
		}
		public EqualityExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterEqualityExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitEqualityExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExprContext equalityExpr() throws RecognitionException {
		EqualityExprContext _localctx = new EqualityExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_equalityExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			relationalExpr();
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(213);
					_la = _input.LA(1);
					if ( !(_la==T__27 || _la==T__28) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(214);
					relationalExpr();
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExprContext extends ParserRuleContext {
		public List<AddSubExprContext> addSubExpr() {
			return getRuleContexts(AddSubExprContext.class);
		}
		public AddSubExprContext addSubExpr(int i) {
			return getRuleContext(AddSubExprContext.class,i);
		}
		public RelationalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterRelationalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitRelationalExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitRelationalExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExprContext relationalExpr() throws RecognitionException {
		RelationalExprContext _localctx = new RelationalExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_relationalExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			addSubExpr();
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(221);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16106127360L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(222);
					addSubExpr();
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExprContext extends ParserRuleContext {
		public List<MulDivExprContext> mulDivExpr() {
			return getRuleContexts(MulDivExprContext.class);
		}
		public MulDivExprContext mulDivExpr(int i) {
			return getRuleContext(MulDivExprContext.class,i);
		}
		public AddSubExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addSubExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterAddSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitAddSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitAddSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddSubExprContext addSubExpr() throws RecognitionException {
		AddSubExprContext _localctx = new AddSubExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_addSubExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			mulDivExpr();
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(229);
					_la = _input.LA(1);
					if ( !(_la==T__33 || _la==T__34) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(230);
					mulDivExpr();
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulDivExprContext extends ParserRuleContext {
		public List<UnaryExprContext> unaryExpr() {
			return getRuleContexts(UnaryExprContext.class);
		}
		public UnaryExprContext unaryExpr(int i) {
			return getRuleContext(UnaryExprContext.class,i);
		}
		public MulDivExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulDivExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterMulDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitMulDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitMulDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulDivExprContext mulDivExpr() throws RecognitionException {
		MulDivExprContext _localctx = new MulDivExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_mulDivExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			unaryExpr();
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(237);
					_la = _input.LA(1);
					if ( !(_la==T__35 || _la==T__36) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(238);
					unaryExpr();
					}
					} 
				}
				setState(243);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitUnaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_unaryExpr);
		try {
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				match(T__34);
				setState(245);
				unaryExpr();
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				match(T__33);
				setState(247);
				unaryExpr();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				match(T__37);
				setState(249);
				unaryExpr();
				}
				break;
			case T__1:
			case T__38:
			case T__39:
			case T__40:
			case VarName:
			case CapitalVarName:
			case INT:
			case FLOAT:
			case CHAR:
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringExprContext extends AtomContext {
		public TerminalNode STRING() { return getToken(ArchiCodeParser.STRING, 0); }
		public StringExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterStringExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitStringExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitStringExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatExprContext extends AtomContext {
		public TerminalNode FLOAT() { return getToken(ArchiCodeParser.FLOAT, 0); }
		public FloatExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterFloatExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitFloatExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitFloatExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharExprContext extends AtomContext {
		public TerminalNode CHAR() { return getToken(ArchiCodeParser.CHAR, 0); }
		public CharExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterCharExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitCharExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitCharExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarExprContext extends AtomContext {
		public TerminalNode VarName() { return getToken(ArchiCodeParser.VarName, 0); }
		public TerminalNode INT() { return getToken(ArchiCodeParser.INT, 0); }
		public VarExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntExprContext extends AtomContext {
		public TerminalNode INT() { return getToken(ArchiCodeParser.INT, 0); }
		public IntExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitIntExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolFalseExprContext extends AtomContext {
		public BoolFalseExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterBoolFalseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitBoolFalseExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitBoolFalseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallExprContext extends AtomContext {
		public TerminalNode CapitalVarName() { return getToken(ArchiCodeParser.CapitalVarName, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncCallExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterFuncCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitFuncCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitFuncCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends AtomContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolTrueExprContext extends AtomContext {
		public BoolTrueExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterBoolTrueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitBoolTrueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitBoolTrueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StepExprContext extends AtomContext {
		public TerminalNode INT() { return getToken(ArchiCodeParser.INT, 0); }
		public StepExprContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterStepExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitStepExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitStepExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_atom);
		int _la;
		try {
			int _alt;
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new FuncCallExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				match(CapitalVarName);
				setState(257);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(254);
						expr();
						}
						} 
					}
					setState(259);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				setState(261);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(260);
					match(T__14);
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new IntExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				match(INT);
				}
				break;
			case 3:
				_localctx = new FloatExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(264);
				match(FLOAT);
				}
				break;
			case 4:
				_localctx = new StringExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(265);
				match(STRING);
				}
				break;
			case 5:
				_localctx = new CharExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(266);
				match(CHAR);
				}
				break;
			case 6:
				_localctx = new BoolTrueExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(267);
				match(T__38);
				}
				break;
			case 7:
				_localctx = new BoolFalseExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(268);
				match(T__39);
				}
				break;
			case 8:
				_localctx = new StepExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(269);
				match(T__40);
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(270);
					match(T__41);
					setState(271);
					match(INT);
					}
				}

				}
				break;
			case 9:
				_localctx = new VarExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(274);
				match(VarName);
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(275);
					match(T__41);
					setState(276);
					match(INT);
					}
				}

				}
				break;
			case 10:
				_localctx = new ParenExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(279);
				match(T__1);
				setState(280);
				expr();
				setState(281);
				match(T__2);
				}
				break;
			case 11:
				_localctx = new StepExprContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(283);
				match(T__40);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			expr();
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(287);
				match(T__15);
				setState(288);
				expr();
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 272678883688448L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u00019\u0129\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0004\u00006\b\u0000\u000b\u0000"+
		"\f\u00007\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001F\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002K\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0003\u0004X\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005f\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005j\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\bw\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u007f\b\b\u0003\b\u0081\b\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0004\t\u0087\b\t\u000b\t\f\t\u0088\u0001\t\u0003\t\u008c\b\t\u0001\n"+
		"\u0001\n\u0001\n\u0005\n\u0091\b\n\n\n\f\n\u0094\t\n\u0001\u000b\u0003"+
		"\u000b\u0097\b\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u009e\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00ad\b\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00b6\b\r\u0003\r\u00b8"+
		"\b\r\u0001\u000e\u0001\u000e\u0005\u000e\u00bc\b\u000e\n\u000e\f\u000e"+
		"\u00bf\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u00c8\b\u0010\n\u0010\f\u0010\u00cb"+
		"\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00d0\b\u0011"+
		"\n\u0011\f\u0011\u00d3\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012\u00d8\b\u0012\n\u0012\f\u0012\u00db\t\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u00e0\b\u0013\n\u0013\f\u0013\u00e3\t\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00e8\b\u0014\n\u0014\f\u0014"+
		"\u00eb\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00f0\b"+
		"\u0015\n\u0015\f\u0015\u00f3\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00fc\b\u0016"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u0100\b\u0017\n\u0017\f\u0017\u0103"+
		"\t\u0017\u0001\u0017\u0003\u0017\u0106\b\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u0111\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0003\u0017\u0116\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u011d\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0005\u0018\u0122\b\u0018\n\u0018\f\u0018\u0125\t\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0000\u0000\u001a\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02\u0000\u0006"+
		"\u0001\u0000\b\n\u0001\u0000\u001c\u001d\u0001\u0000\u001e!\u0001\u0000"+
		"\"#\u0001\u0000$%\u0001\u0000+/\u0141\u00005\u0001\u0000\u0000\u0000\u0002"+
		"E\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006R\u0001"+
		"\u0000\u0000\u0000\bU\u0001\u0000\u0000\u0000\n]\u0001\u0000\u0000\u0000"+
		"\fk\u0001\u0000\u0000\u0000\u000eo\u0001\u0000\u0000\u0000\u0010r\u0001"+
		"\u0000\u0000\u0000\u0012\u0084\u0001\u0000\u0000\u0000\u0014\u008d\u0001"+
		"\u0000\u0000\u0000\u0016\u0096\u0001\u0000\u0000\u0000\u0018\u00ac\u0001"+
		"\u0000\u0000\u0000\u001a\u00ae\u0001\u0000\u0000\u0000\u001c\u00b9\u0001"+
		"\u0000\u0000\u0000\u001e\u00c2\u0001\u0000\u0000\u0000 \u00c4\u0001\u0000"+
		"\u0000\u0000\"\u00cc\u0001\u0000\u0000\u0000$\u00d4\u0001\u0000\u0000"+
		"\u0000&\u00dc\u0001\u0000\u0000\u0000(\u00e4\u0001\u0000\u0000\u0000*"+
		"\u00ec\u0001\u0000\u0000\u0000,\u00fb\u0001\u0000\u0000\u0000.\u011c\u0001"+
		"\u0000\u0000\u00000\u011e\u0001\u0000\u0000\u00002\u0126\u0001\u0000\u0000"+
		"\u000046\u0003\u0002\u0001\u000054\u0001\u0000\u0000\u000067\u0001\u0000"+
		"\u0000\u000075\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u000089\u0001"+
		"\u0000\u0000\u00009:\u0005\u0000\u0000\u0001:\u0001\u0001\u0000\u0000"+
		"\u0000;F\u0003\u0006\u0003\u0000<F\u0003\b\u0004\u0000=F\u0003\n\u0005"+
		"\u0000>F\u0003\f\u0006\u0000?F\u0003\u000e\u0007\u0000@F\u0003\u0018\f"+
		"\u0000AF\u0003\u001a\r\u0000BF\u0003\u0010\b\u0000CF\u0003\u0012\t\u0000"+
		"DF\u0003\u0004\u0002\u0000E;\u0001\u0000\u0000\u0000E<\u0001\u0000\u0000"+
		"\u0000E=\u0001\u0000\u0000\u0000E>\u0001\u0000\u0000\u0000E?\u0001\u0000"+
		"\u0000\u0000E@\u0001\u0000\u0000\u0000EA\u0001\u0000\u0000\u0000EB\u0001"+
		"\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000"+
		"F\u0003\u0001\u0000\u0000\u0000GH\u0005\u0001\u0000\u0000HJ\u0005\u0002"+
		"\u0000\u0000IK\u0003\u0014\n\u0000JI\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0005\u0003\u0000\u0000MN\u0005"+
		"\u0004\u0000\u0000NO\u00032\u0019\u0000OP\u00050\u0000\u0000PQ\u0003\u001c"+
		"\u000e\u0000Q\u0005\u0001\u0000\u0000\u0000RS\u0005\u0005\u0000\u0000"+
		"ST\u0003\u001e\u000f\u0000T\u0007\u0001\u0000\u0000\u0000UW\u0005\u0006"+
		"\u0000\u0000VX\u00032\u0019\u0000WV\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u00050\u0000\u0000Z[\u0005\u0007"+
		"\u0000\u0000[\\\u0003\u001e\u000f\u0000\\\t\u0001\u0000\u0000\u0000]^"+
		"\u0005\u0006\u0000\u0000^_\u0007\u0000\u0000\u0000_`\u00032\u0019\u0000"+
		"`e\u00050\u0000\u0000ab\u0005\u000b\u0000\u0000bc\u0003\u001e\u000f\u0000"+
		"cd\u0005\f\u0000\u0000df\u0001\u0000\u0000\u0000ea\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000gh\u0005\u0007\u0000"+
		"\u0000hj\u0003\u001e\u000f\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000"+
		"\u0000\u0000j\u000b\u0001\u0000\u0000\u0000kl\u00050\u0000\u0000lm\u0005"+
		"\u0007\u0000\u0000mn\u0003\u001e\u000f\u0000n\r\u0001\u0000\u0000\u0000"+
		"op\u0005\r\u0000\u0000pq\u00050\u0000\u0000q\u000f\u0001\u0000\u0000\u0000"+
		"rs\u0005\u000e\u0000\u0000st\u00051\u0000\u0000tv\u0005\u0002\u0000\u0000"+
		"uw\u0003\u0014\n\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000x\u0080\u0005\u0003\u0000\u0000yz\u0005\u0004"+
		"\u0000\u0000z{\u00032\u0019\u0000{~\u00050\u0000\u0000|}\u0005\u0007\u0000"+
		"\u0000}\u007f\u0003\u001e\u000f\u0000~|\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080y\u0001"+
		"\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0003\u001c\u000e\u0000\u0083\u0011\u0001"+
		"\u0000\u0000\u0000\u0084\u0086\u00051\u0000\u0000\u0085\u0087\u0003\u001e"+
		"\u000f\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000"+
		"\u0000\u0000\u0089\u008b\u0001\u0000\u0000\u0000\u008a\u008c\u0005\u000f"+
		"\u0000\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000"+
		"\u0000\u0000\u008c\u0013\u0001\u0000\u0000\u0000\u008d\u0092\u0003\u0016"+
		"\u000b\u0000\u008e\u008f\u0005\u0010\u0000\u0000\u008f\u0091\u0003\u0016"+
		"\u000b\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0094\u0001\u0000"+
		"\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093\u0015\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000"+
		"\u0000\u0000\u0095\u0097\u00032\u0019\u0000\u0096\u0095\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u00050\u0000\u0000\u0099\u0017\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0005\u0011\u0000\u0000\u009b\u009d\u0003\u001e\u000f\u0000"+
		"\u009c\u009e\u0003\u001e\u000f\u0000\u009d\u009c\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000"+
		"\u009f\u00a0\u0003\u001c\u000e\u0000\u00a0\u00ad\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a2\u0005\u0011\u0000\u0000\u00a2\u00a3\u0005\u0012\u0000\u0000"+
		"\u00a3\u00a4\u0003\u001e\u000f\u0000\u00a4\u00a5\u0003\u001c\u000e\u0000"+
		"\u00a5\u00ad\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0011\u0000\u0000"+
		"\u00a7\u00a8\u0005\u0013\u0000\u0000\u00a8\u00a9\u00050\u0000\u0000\u00a9"+
		"\u00aa\u0005\u0014\u0000\u0000\u00aa\u00ab\u00050\u0000\u0000\u00ab\u00ad"+
		"\u0003\u001c\u000e\u0000\u00ac\u009a\u0001\u0000\u0000\u0000\u00ac\u00a1"+
		"\u0001\u0000\u0000\u0000\u00ac\u00a6\u0001\u0000\u0000\u0000\u00ad\u0019"+
		"\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u0015\u0000\u0000\u00af\u00b0"+
		"\u0003\u001e\u000f\u0000\u00b0\u00b1\u0005\u0016\u0000\u0000\u00b1\u00b7"+
		"\u0003\u001c\u000e\u0000\u00b2\u00b5\u0005\u0017\u0000\u0000\u00b3\u00b6"+
		"\u0003\u001a\r\u0000\u00b4\u00b6\u0003\u001c\u000e\u0000\u00b5\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b2\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b8\u001b\u0001\u0000\u0000\u0000\u00b9\u00bd\u0005"+
		"\u0018\u0000\u0000\u00ba\u00bc\u0003\u0002\u0001\u0000\u00bb\u00ba\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c0\u0001"+
		"\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005"+
		"\u0019\u0000\u0000\u00c1\u001d\u0001\u0000\u0000\u0000\u00c2\u00c3\u0003"+
		" \u0010\u0000\u00c3\u001f\u0001\u0000\u0000\u0000\u00c4\u00c9\u0003\""+
		"\u0011\u0000\u00c5\u00c6\u0005\u001a\u0000\u0000\u00c6\u00c8\u0003\"\u0011"+
		"\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000"+
		"\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000"+
		"\u0000\u00ca!\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000"+
		"\u00cc\u00d1\u0003$\u0012\u0000\u00cd\u00ce\u0005\u001b\u0000\u0000\u00ce"+
		"\u00d0\u0003$\u0012\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d2#\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d9\u0003&\u0013\u0000\u00d5\u00d6\u0007\u0001"+
		"\u0000\u0000\u00d6\u00d8\u0003&\u0013\u0000\u00d7\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da%\u0001\u0000\u0000\u0000"+
		"\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00e1\u0003(\u0014\u0000\u00dd"+
		"\u00de\u0007\u0002\u0000\u0000\u00de\u00e0\u0003(\u0014\u0000\u00df\u00dd"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1\u00df"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\'\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e9\u0003"+
		"*\u0015\u0000\u00e5\u00e6\u0007\u0003\u0000\u0000\u00e6\u00e8\u0003*\u0015"+
		"\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000"+
		"\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ea)\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000"+
		"\u00ec\u00f1\u0003,\u0016\u0000\u00ed\u00ee\u0007\u0004\u0000\u0000\u00ee"+
		"\u00f0\u0003,\u0016\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f2+\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f5\u0005#\u0000\u0000\u00f5\u00fc\u0003,\u0016"+
		"\u0000\u00f6\u00f7\u0005\"\u0000\u0000\u00f7\u00fc\u0003,\u0016\u0000"+
		"\u00f8\u00f9\u0005&\u0000\u0000\u00f9\u00fc\u0003,\u0016\u0000\u00fa\u00fc"+
		"\u0003.\u0017\u0000\u00fb\u00f4\u0001\u0000\u0000\u0000\u00fb\u00f6\u0001"+
		"\u0000\u0000\u0000\u00fb\u00f8\u0001\u0000\u0000\u0000\u00fb\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fc-\u0001\u0000\u0000\u0000\u00fd\u0101\u00051\u0000"+
		"\u0000\u00fe\u0100\u0003\u001e\u000f\u0000\u00ff\u00fe\u0001\u0000\u0000"+
		"\u0000\u0100\u0103\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000"+
		"\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0105\u0001\u0000\u0000"+
		"\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0104\u0106\u0005\u000f\u0000"+
		"\u0000\u0105\u0104\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000"+
		"\u0000\u0106\u011d\u0001\u0000\u0000\u0000\u0107\u011d\u00052\u0000\u0000"+
		"\u0108\u011d\u00053\u0000\u0000\u0109\u011d\u00055\u0000\u0000\u010a\u011d"+
		"\u00054\u0000\u0000\u010b\u011d\u0005\'\u0000\u0000\u010c\u011d\u0005"+
		"(\u0000\u0000\u010d\u0110\u0005)\u0000\u0000\u010e\u010f\u0005*\u0000"+
		"\u0000\u010f\u0111\u00052\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000"+
		"\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u011d\u0001\u0000\u0000\u0000"+
		"\u0112\u0115\u00050\u0000\u0000\u0113\u0114\u0005*\u0000\u0000\u0114\u0116"+
		"\u00052\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0116\u0001"+
		"\u0000\u0000\u0000\u0116\u011d\u0001\u0000\u0000\u0000\u0117\u0118\u0005"+
		"\u0002\u0000\u0000\u0118\u0119\u0003\u001e\u000f\u0000\u0119\u011a\u0005"+
		"\u0003\u0000\u0000\u011a\u011d\u0001\u0000\u0000\u0000\u011b\u011d\u0005"+
		")\u0000\u0000\u011c\u00fd\u0001\u0000\u0000\u0000\u011c\u0107\u0001\u0000"+
		"\u0000\u0000\u011c\u0108\u0001\u0000\u0000\u0000\u011c\u0109\u0001\u0000"+
		"\u0000\u0000\u011c\u010a\u0001\u0000\u0000\u0000\u011c\u010b\u0001\u0000"+
		"\u0000\u0000\u011c\u010c\u0001\u0000\u0000\u0000\u011c\u010d\u0001\u0000"+
		"\u0000\u0000\u011c\u0112\u0001\u0000\u0000\u0000\u011c\u0117\u0001\u0000"+
		"\u0000\u0000\u011c\u011b\u0001\u0000\u0000\u0000\u011d/\u0001\u0000\u0000"+
		"\u0000\u011e\u0123\u0003\u001e\u000f\u0000\u011f\u0120\u0005\u0010\u0000"+
		"\u0000\u0120\u0122\u0003\u001e\u000f\u0000\u0121\u011f\u0001\u0000\u0000"+
		"\u0000\u0122\u0125\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000"+
		"\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u01241\u0001\u0000\u0000\u0000"+
		"\u0125\u0123\u0001\u0000\u0000\u0000\u0126\u0127\u0007\u0005\u0000\u0000"+
		"\u01273\u0001\u0000\u0000\u0000\u001f7EJWeiv~\u0080\u0088\u008b\u0092"+
		"\u0096\u009d\u00ac\u00b5\u00b7\u00bd\u00c9\u00d1\u00d9\u00e1\u00e9\u00f1"+
		"\u00fb\u0101\u0105\u0110\u0115\u011c\u0123";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}