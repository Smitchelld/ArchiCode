// Generated from C:/studia/Kompilatory/gramatyka/gramatyka/ArchiCode.g4 by ANTLR 4.13.2
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
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, VarName=45, 
		CapitalVarName=46, INT=47, CHAR=48, STRING=49, INLINE_COMMENT=50, LINE_COMMENT=51, 
		MULTILINE_COMMENT=52, WS=53;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_coreStatement = 2, RULE_showStatement = 3, 
		RULE_defineStatement = 4, RULE_defineCollectionStatement = 5, RULE_assignStatement = 6, 
		RULE_requestStatement = 7, RULE_blueprintStatement = 8, RULE_blueprintCallStatement = 9, 
		RULE_paramList = 10, RULE_param = 11, RULE_repeatStatement = 12, RULE_checkStatement = 13, 
		RULE_block = 14, RULE_expr = 15, RULE_exprList = 16, RULE_type = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "coreStatement", "showStatement", "defineStatement", 
			"defineCollectionStatement", "assignStatement", "requestStatement", "blueprintStatement", 
			"blueprintCallStatement", "paramList", "param", "repeatStatement", "checkStatement", 
			"block", "expr", "exprList", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Core'", "'('", "')'", "'delivers'", "'show'", "'define'", "'='", 
			"'box'", "'chain'", "'catalog'", "'['", "']'", "'request'", "'blueprint'", 
			"';'", "','", "'repeat'", "'until'", "'for'", "'in'", "'check'", "'then'", 
			"'otherwise'", "'{'", "'}'", "'-'", "'not'", "'and'", "'or'", "'*'", 
			"'/'", "'+'", "'=='", "'<'", "'>'", "'true'", "'false'", "'step'", "'@'", 
			"'int'", "'float'", "'bool'", "'char'", "'string'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "VarName", "CapitalVarName", 
			"INT", "CHAR", "STRING", "INLINE_COMMENT", "LINE_COMMENT", "MULTILINE_COMMENT", 
			"WS"
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
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				statement();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 105553118519394L) != 0) );
			setState(41);
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
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				showStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				defineStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				defineCollectionStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				assignStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(47);
				requestStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(48);
				repeatStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(49);
				checkStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(50);
				blueprintStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(51);
				blueprintCallStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(52);
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
			setState(55);
			match(T__0);
			setState(56);
			match(T__1);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69269232549888L) != 0)) {
				{
				setState(57);
				paramList();
				}
			}

			setState(60);
			match(T__2);
			setState(61);
			match(T__3);
			setState(62);
			type();
			setState(63);
			match(VarName);
			setState(64);
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
			setState(66);
			match(T__4);
			setState(67);
			expr(0);
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
			setState(69);
			match(T__5);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34084860461056L) != 0)) {
				{
				setState(70);
				type();
				}
			}

			setState(73);
			match(VarName);
			setState(74);
			match(T__6);
			setState(75);
			expr(0);
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
			setState(77);
			match(T__5);
			setState(78);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(79);
			type();
			setState(80);
			match(VarName);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(81);
				match(T__10);
				setState(82);
				expr(0);
				setState(83);
				match(T__11);
				}
			}

			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(87);
				match(T__6);
				setState(88);
				expr(0);
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
			setState(91);
			match(VarName);
			setState(92);
			match(T__6);
			setState(93);
			expr(0);
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
			setState(95);
			match(T__12);
			setState(96);
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
			setState(98);
			match(T__13);
			setState(99);
			match(CapitalVarName);
			setState(100);
			match(T__1);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 69269232549888L) != 0)) {
				{
				setState(101);
				paramList();
				}
			}

			setState(104);
			match(T__2);
			setState(105);
			match(T__3);
			setState(106);
			type();
			setState(107);
			match(VarName);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(108);
				match(T__6);
				setState(109);
				expr(0);
				}
			}

			setState(112);
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
			setState(114);
			match(CapitalVarName);
			setState(116); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(115);
					expr(0);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(118); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(120);
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
			setState(123);
			param();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(124);
				match(T__15);
				setState(125);
				param();
				}
				}
				setState(130);
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
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34084860461056L) != 0)) {
				{
				setState(131);
				type();
				}
			}

			setState(134);
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
		public TerminalNode INT() { return getToken(ArchiCodeParser.INT, 0); }
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
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new RepeatFixedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(T__16);
				setState(137);
				match(INT);
				setState(138);
				block();
				}
				break;
			case 2:
				_localctx = new RepeatUntilContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(T__16);
				setState(140);
				match(T__17);
				setState(141);
				expr(0);
				setState(142);
				block();
				}
				break;
			case 3:
				_localctx = new RepeatForContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				match(T__16);
				setState(145);
				match(T__18);
				setState(146);
				match(VarName);
				setState(147);
				match(T__19);
				setState(148);
				match(VarName);
				setState(149);
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
			setState(152);
			match(T__20);
			setState(153);
			expr(0);
			setState(154);
			match(T__21);
			setState(155);
			block();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(156);
				match(T__22);
				setState(159);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__20:
					{
					setState(157);
					checkStatement();
					}
					break;
				case T__23:
					{
					setState(158);
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
			setState(163);
			match(T__23);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 105553118519394L) != 0)) {
				{
				{
				setState(164);
				statement();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharExprContext extends ExprContext {
		public TerminalNode CHAR() { return getToken(ArchiCodeParser.CHAR, 0); }
		public CharExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class IntExprContext extends ExprContext {
		public TerminalNode INT() { return getToken(ArchiCodeParser.INT, 0); }
		public IntExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class AddSubExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class GtExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GtExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterGtExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitGtExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitGtExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolFalseExprContext extends ExprContext {
		public BoolFalseExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class FuncCallExprContext extends ExprContext {
		public TerminalNode CapitalVarName() { return getToken(ArchiCodeParser.CapitalVarName, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public FuncCallExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class BoolTrueExprContext extends ExprContext {
		public BoolTrueExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class StringExprContext extends ExprContext {
		public TerminalNode STRING() { return getToken(ArchiCodeParser.STRING, 0); }
		public StringExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class NegateExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterNegateExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitNegateExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitNegateExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarExprContext extends ExprContext {
		public TerminalNode VarName() { return getToken(ArchiCodeParser.VarName, 0); }
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class FuncCallNoParensExprContext extends ExprContext {
		public TerminalNode CapitalVarName() { return getToken(ArchiCodeParser.CapitalVarName, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncCallNoParensExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterFuncCallNoParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitFuncCallNoParensExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitFuncCallNoParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterEqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitEqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LtExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LtExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterLtExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitLtExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitLtExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LogicExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).enterLogicExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArchiCodeListener ) ((ArchiCodeListener)listener).exitLogicExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArchiCodeVisitor ) return ((ArchiCodeVisitor<? extends T>)visitor).visitLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivExprContext(ExprContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class StepExprContext extends ExprContext {
		public TerminalNode INT() { return getToken(ArchiCodeParser.INT, 0); }
		public StepExprContext(ExprContext ctx) { copyFrom(ctx); }
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

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				_localctx = new NegateExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(173);
				match(T__25);
				setState(174);
				expr(18);
				}
				break;
			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				match(T__26);
				setState(176);
				expr(17);
				}
				break;
			case 3:
				{
				_localctx = new FuncCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(CapitalVarName);
				setState(178);
				match(T__1);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1091196772417540L) != 0)) {
					{
					setState(179);
					exprList();
					}
				}

				setState(182);
				match(T__2);
				}
				break;
			case 4:
				{
				_localctx = new FuncCallNoParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(CapitalVarName);
				setState(185); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(184);
						expr(0);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(187); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(190);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(189);
					match(T__14);
					}
					break;
				}
				}
				break;
			case 5:
				{
				_localctx = new IntExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(INT);
				}
				break;
			case 6:
				{
				_localctx = new StringExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new CharExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				match(CHAR);
				}
				break;
			case 8:
				{
				_localctx = new BoolTrueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(T__35);
				}
				break;
			case 9:
				{
				_localctx = new BoolFalseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				match(T__36);
				}
				break;
			case 10:
				{
				_localctx = new StepExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(T__37);
				setState(200);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(198);
					match(T__38);
					setState(199);
					match(INT);
					}
					break;
				}
				}
				break;
			case 11:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(VarName);
				}
				break;
			case 12:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				match(T__1);
				setState(204);
				expr(0);
				setState(205);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(227);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new LogicExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(210);
						((LogicExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__27 || _la==T__28) ) {
							((LogicExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(211);
						expr(17);
						}
						break;
					case 2:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(212);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(213);
						((MulDivExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__29 || _la==T__30) ) {
							((MulDivExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(214);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(216);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__31) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(217);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new EqExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(218);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(219);
						match(T__32);
						setState(220);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new LtExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(221);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(222);
						match(T__33);
						setState(223);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new GtExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(225);
						match(T__34);
						setState(226);
						expr(12);
						}
						break;
					}
					} 
				}
				setState(231);
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
			unrollRecursionContexts(_parentctx);
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
		enterRule(_localctx, 32, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			expr(0);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(233);
				match(T__15);
				setState(234);
				expr(0);
				}
				}
				setState(239);
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
		enterRule(_localctx, 34, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 34084860461056L) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00015\u00f3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0004\u0000"+
		"&\b\u0000\u000b\u0000\f\u0000\'\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u00016\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002;\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0003\u0004H\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005V\b"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005Z\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\bg\b\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\bo\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0004"+
		"\tu\b\t\u000b\t\f\tv\u0001\t\u0003\tz\b\t\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u007f\b\n\n\n\f\n\u0082\t\n\u0001\u000b\u0003\u000b\u0085\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0097"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00a0"+
		"\b\r\u0003\r\u00a2\b\r\u0001\u000e\u0001\u000e\u0005\u000e\u00a6\b\u000e"+
		"\n\u000e\f\u000e\u00a9\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00b5\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0004"+
		"\u000f\u00ba\b\u000f\u000b\u000f\f\u000f\u00bb\u0001\u000f\u0003\u000f"+
		"\u00bf\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00c9\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00d0\b\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u00e4\b\u000f\n\u000f\f\u000f\u00e7\t\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u00ec\b\u0010\n\u0010\f\u0010\u00ef\t\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0001\u001e\u0012\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"\u0000\u0005\u0001\u0000\b\n\u0001\u0000\u001c\u001d\u0001\u0000\u001e"+
		"\u001f\u0002\u0000\u001a\u001a  \u0001\u0000(,\u010f\u0000%\u0001\u0000"+
		"\u0000\u0000\u00025\u0001\u0000\u0000\u0000\u00047\u0001\u0000\u0000\u0000"+
		"\u0006B\u0001\u0000\u0000\u0000\bE\u0001\u0000\u0000\u0000\nM\u0001\u0000"+
		"\u0000\u0000\f[\u0001\u0000\u0000\u0000\u000e_\u0001\u0000\u0000\u0000"+
		"\u0010b\u0001\u0000\u0000\u0000\u0012r\u0001\u0000\u0000\u0000\u0014{"+
		"\u0001\u0000\u0000\u0000\u0016\u0084\u0001\u0000\u0000\u0000\u0018\u0096"+
		"\u0001\u0000\u0000\u0000\u001a\u0098\u0001\u0000\u0000\u0000\u001c\u00a3"+
		"\u0001\u0000\u0000\u0000\u001e\u00cf\u0001\u0000\u0000\u0000 \u00e8\u0001"+
		"\u0000\u0000\u0000\"\u00f0\u0001\u0000\u0000\u0000$&\u0003\u0002\u0001"+
		"\u0000%$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'%\u0001\u0000"+
		"\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)*\u0005"+
		"\u0000\u0000\u0001*\u0001\u0001\u0000\u0000\u0000+6\u0003\u0006\u0003"+
		"\u0000,6\u0003\b\u0004\u0000-6\u0003\n\u0005\u0000.6\u0003\f\u0006\u0000"+
		"/6\u0003\u000e\u0007\u000006\u0003\u0018\f\u000016\u0003\u001a\r\u0000"+
		"26\u0003\u0010\b\u000036\u0003\u0012\t\u000046\u0003\u0004\u0002\u0000"+
		"5+\u0001\u0000\u0000\u00005,\u0001\u0000\u0000\u00005-\u0001\u0000\u0000"+
		"\u00005.\u0001\u0000\u0000\u00005/\u0001\u0000\u0000\u000050\u0001\u0000"+
		"\u0000\u000051\u0001\u0000\u0000\u000052\u0001\u0000\u0000\u000053\u0001"+
		"\u0000\u0000\u000054\u0001\u0000\u0000\u00006\u0003\u0001\u0000\u0000"+
		"\u000078\u0005\u0001\u0000\u00008:\u0005\u0002\u0000\u00009;\u0003\u0014"+
		"\n\u0000:9\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0001\u0000"+
		"\u0000\u0000<=\u0005\u0003\u0000\u0000=>\u0005\u0004\u0000\u0000>?\u0003"+
		"\"\u0011\u0000?@\u0005-\u0000\u0000@A\u0003\u001c\u000e\u0000A\u0005\u0001"+
		"\u0000\u0000\u0000BC\u0005\u0005\u0000\u0000CD\u0003\u001e\u000f\u0000"+
		"D\u0007\u0001\u0000\u0000\u0000EG\u0005\u0006\u0000\u0000FH\u0003\"\u0011"+
		"\u0000GF\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000IJ\u0005-\u0000\u0000JK\u0005\u0007\u0000\u0000KL\u0003\u001e"+
		"\u000f\u0000L\t\u0001\u0000\u0000\u0000MN\u0005\u0006\u0000\u0000NO\u0007"+
		"\u0000\u0000\u0000OP\u0003\"\u0011\u0000PU\u0005-\u0000\u0000QR\u0005"+
		"\u000b\u0000\u0000RS\u0003\u001e\u000f\u0000ST\u0005\f\u0000\u0000TV\u0001"+
		"\u0000\u0000\u0000UQ\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VY\u0001\u0000\u0000\u0000WX\u0005\u0007\u0000\u0000XZ\u0003\u001e\u000f"+
		"\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\u000b\u0001"+
		"\u0000\u0000\u0000[\\\u0005-\u0000\u0000\\]\u0005\u0007\u0000\u0000]^"+
		"\u0003\u001e\u000f\u0000^\r\u0001\u0000\u0000\u0000_`\u0005\r\u0000\u0000"+
		"`a\u0005-\u0000\u0000a\u000f\u0001\u0000\u0000\u0000bc\u0005\u000e\u0000"+
		"\u0000cd\u0005.\u0000\u0000df\u0005\u0002\u0000\u0000eg\u0003\u0014\n"+
		"\u0000fe\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000"+
		"\u0000\u0000hi\u0005\u0003\u0000\u0000ij\u0005\u0004\u0000\u0000jk\u0003"+
		"\"\u0011\u0000kn\u0005-\u0000\u0000lm\u0005\u0007\u0000\u0000mo\u0003"+
		"\u001e\u000f\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000pq\u0003\u001c\u000e\u0000q\u0011\u0001\u0000"+
		"\u0000\u0000rt\u0005.\u0000\u0000su\u0003\u001e\u000f\u0000ts\u0001\u0000"+
		"\u0000\u0000uv\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001"+
		"\u0000\u0000\u0000wy\u0001\u0000\u0000\u0000xz\u0005\u000f\u0000\u0000"+
		"yx\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z\u0013\u0001\u0000"+
		"\u0000\u0000{\u0080\u0003\u0016\u000b\u0000|}\u0005\u0010\u0000\u0000"+
		"}\u007f\u0003\u0016\u000b\u0000~|\u0001\u0000\u0000\u0000\u007f\u0082"+
		"\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001"+
		"\u0000\u0000\u0000\u0081\u0015\u0001\u0000\u0000\u0000\u0082\u0080\u0001"+
		"\u0000\u0000\u0000\u0083\u0085\u0003\"\u0011\u0000\u0084\u0083\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0005-\u0000\u0000\u0087\u0017\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0005\u0011\u0000\u0000\u0089\u008a\u0005/\u0000\u0000"+
		"\u008a\u0097\u0003\u001c\u000e\u0000\u008b\u008c\u0005\u0011\u0000\u0000"+
		"\u008c\u008d\u0005\u0012\u0000\u0000\u008d\u008e\u0003\u001e\u000f\u0000"+
		"\u008e\u008f\u0003\u001c\u000e\u0000\u008f\u0097\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0005\u0011\u0000\u0000\u0091\u0092\u0005\u0013\u0000\u0000"+
		"\u0092\u0093\u0005-\u0000\u0000\u0093\u0094\u0005\u0014\u0000\u0000\u0094"+
		"\u0095\u0005-\u0000\u0000\u0095\u0097\u0003\u001c\u000e\u0000\u0096\u0088"+
		"\u0001\u0000\u0000\u0000\u0096\u008b\u0001\u0000\u0000\u0000\u0096\u0090"+
		"\u0001\u0000\u0000\u0000\u0097\u0019\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0005\u0015\u0000\u0000\u0099\u009a\u0003\u001e\u000f\u0000\u009a\u009b"+
		"\u0005\u0016\u0000\u0000\u009b\u00a1\u0003\u001c\u000e\u0000\u009c\u009f"+
		"\u0005\u0017\u0000\u0000\u009d\u00a0\u0003\u001a\r\u0000\u009e\u00a0\u0003"+
		"\u001c\u000e\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u009e\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a2\u0001\u0000\u0000\u0000\u00a1\u009c\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u001b\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a7\u0005\u0018\u0000\u0000\u00a4\u00a6\u0003"+
		"\u0002\u0001\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0005\u0019\u0000\u0000\u00ab\u001d\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0006\u000f\uffff\uffff\u0000\u00ad\u00ae"+
		"\u0005\u001a\u0000\u0000\u00ae\u00d0\u0003\u001e\u000f\u0012\u00af\u00b0"+
		"\u0005\u001b\u0000\u0000\u00b0\u00d0\u0003\u001e\u000f\u0011\u00b1\u00b2"+
		"\u0005.\u0000\u0000\u00b2\u00b4\u0005\u0002\u0000\u0000\u00b3\u00b5\u0003"+
		" \u0010\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00d0\u0005\u0003"+
		"\u0000\u0000\u00b7\u00b9\u0005.\u0000\u0000\u00b8\u00ba\u0003\u001e\u000f"+
		"\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00bf\u0005\u000f\u0000"+
		"\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000"+
		"\u0000\u00bf\u00d0\u0001\u0000\u0000\u0000\u00c0\u00d0\u0005/\u0000\u0000"+
		"\u00c1\u00d0\u00051\u0000\u0000\u00c2\u00d0\u00050\u0000\u0000\u00c3\u00d0"+
		"\u0005$\u0000\u0000\u00c4\u00d0\u0005%\u0000\u0000\u00c5\u00c8\u0005&"+
		"\u0000\u0000\u00c6\u00c7\u0005\'\u0000\u0000\u00c7\u00c9\u0005/\u0000"+
		"\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000"+
		"\u0000\u00c9\u00d0\u0001\u0000\u0000\u0000\u00ca\u00d0\u0005-\u0000\u0000"+
		"\u00cb\u00cc\u0005\u0002\u0000\u0000\u00cc\u00cd\u0003\u001e\u000f\u0000"+
		"\u00cd\u00ce\u0005\u0003\u0000\u0000\u00ce\u00d0\u0001\u0000\u0000\u0000"+
		"\u00cf\u00ac\u0001\u0000\u0000\u0000\u00cf\u00af\u0001\u0000\u0000\u0000"+
		"\u00cf\u00b1\u0001\u0000\u0000\u0000\u00cf\u00b7\u0001\u0000\u0000\u0000"+
		"\u00cf\u00c0\u0001\u0000\u0000\u0000\u00cf\u00c1\u0001\u0000\u0000\u0000"+
		"\u00cf\u00c2\u0001\u0000\u0000\u0000\u00cf\u00c3\u0001\u0000\u0000\u0000"+
		"\u00cf\u00c4\u0001\u0000\u0000\u0000\u00cf\u00c5\u0001\u0000\u0000\u0000"+
		"\u00cf\u00ca\u0001\u0000\u0000\u0000\u00cf\u00cb\u0001\u0000\u0000\u0000"+
		"\u00d0\u00e5\u0001\u0000\u0000\u0000\u00d1\u00d2\n\u0010\u0000\u0000\u00d2"+
		"\u00d3\u0007\u0001\u0000\u0000\u00d3\u00e4\u0003\u001e\u000f\u0011\u00d4"+
		"\u00d5\n\u000f\u0000\u0000\u00d5\u00d6\u0007\u0002\u0000\u0000\u00d6\u00e4"+
		"\u0003\u001e\u000f\u0010\u00d7\u00d8\n\u000e\u0000\u0000\u00d8\u00d9\u0007"+
		"\u0003\u0000\u0000\u00d9\u00e4\u0003\u001e\u000f\u000f\u00da\u00db\n\r"+
		"\u0000\u0000\u00db\u00dc\u0005!\u0000\u0000\u00dc\u00e4\u0003\u001e\u000f"+
		"\u000e\u00dd\u00de\n\f\u0000\u0000\u00de\u00df\u0005\"\u0000\u0000\u00df"+
		"\u00e4\u0003\u001e\u000f\r\u00e0\u00e1\n\u000b\u0000\u0000\u00e1\u00e2"+
		"\u0005#\u0000\u0000\u00e2\u00e4\u0003\u001e\u000f\f\u00e3\u00d1\u0001"+
		"\u0000\u0000\u0000\u00e3\u00d4\u0001\u0000\u0000\u0000\u00e3\u00d7\u0001"+
		"\u0000\u0000\u0000\u00e3\u00da\u0001\u0000\u0000\u0000\u00e3\u00dd\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e0\u0001\u0000\u0000\u0000\u00e4\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001"+
		"\u0000\u0000\u0000\u00e6\u001f\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e8\u00ed\u0003\u001e\u000f\u0000\u00e9\u00ea\u0005"+
		"\u0010\u0000\u0000\u00ea\u00ec\u0003\u001e\u000f\u0000\u00eb\u00e9\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001"+
		"\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee!\u0001\u0000"+
		"\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0\u00f1\u0007\u0004"+
		"\u0000\u0000\u00f1#\u0001\u0000\u0000\u0000\u0018\'5:GUYfnvy\u0080\u0084"+
		"\u0096\u009f\u00a1\u00a7\u00b4\u00bb\u00be\u00c8\u00cf\u00e3\u00e5\u00ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}