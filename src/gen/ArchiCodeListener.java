package gen;// Generated from C:/Users/szyro/IdeaProjects/pz1/ArchiCode/ArchiCode.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArchiCodeParser}.
 */
public interface ArchiCodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ArchiCodeParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ArchiCodeParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ArchiCodeParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ArchiCodeParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#coreStatement}.
	 * @param ctx the parse tree
	 */
	void enterCoreStatement(ArchiCodeParser.CoreStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#coreStatement}.
	 * @param ctx the parse tree
	 */
	void exitCoreStatement(ArchiCodeParser.CoreStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#showStatement}.
	 * @param ctx the parse tree
	 */
	void enterShowStatement(ArchiCodeParser.ShowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#showStatement}.
	 * @param ctx the parse tree
	 */
	void exitShowStatement(ArchiCodeParser.ShowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#defineStatement}.
	 * @param ctx the parse tree
	 */
	void enterDefineStatement(ArchiCodeParser.DefineStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#defineStatement}.
	 * @param ctx the parse tree
	 */
	void exitDefineStatement(ArchiCodeParser.DefineStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#defineCollectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterDefineCollectionStatement(ArchiCodeParser.DefineCollectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#defineCollectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitDefineCollectionStatement(ArchiCodeParser.DefineCollectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(ArchiCodeParser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(ArchiCodeParser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#requestStatement}.
	 * @param ctx the parse tree
	 */
	void enterRequestStatement(ArchiCodeParser.RequestStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#requestStatement}.
	 * @param ctx the parse tree
	 */
	void exitRequestStatement(ArchiCodeParser.RequestStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#blueprintStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlueprintStatement(ArchiCodeParser.BlueprintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#blueprintStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlueprintStatement(ArchiCodeParser.BlueprintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#blueprintCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlueprintCallStatement(ArchiCodeParser.BlueprintCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#blueprintCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlueprintCallStatement(ArchiCodeParser.BlueprintCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(ArchiCodeParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(ArchiCodeParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(ArchiCodeParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(ArchiCodeParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code repeatFixed}
	 * labeled alternative in {@link ArchiCodeParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatFixed(ArchiCodeParser.RepeatFixedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code repeatFixed}
	 * labeled alternative in {@link ArchiCodeParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatFixed(ArchiCodeParser.RepeatFixedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code repeatUntil}
	 * labeled alternative in {@link ArchiCodeParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatUntil(ArchiCodeParser.RepeatUntilContext ctx);
	/**
	 * Exit a parse tree produced by the {@code repeatUntil}
	 * labeled alternative in {@link ArchiCodeParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatUntil(ArchiCodeParser.RepeatUntilContext ctx);
	/**
	 * Enter a parse tree produced by the {@code repeatFor}
	 * labeled alternative in {@link ArchiCodeParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatFor(ArchiCodeParser.RepeatForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code repeatFor}
	 * labeled alternative in {@link ArchiCodeParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatFor(ArchiCodeParser.RepeatForContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#checkStatement}.
	 * @param ctx the parse tree
	 */
	void enterCheckStatement(ArchiCodeParser.CheckStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#checkStatement}.
	 * @param ctx the parse tree
	 */
	void exitCheckStatement(ArchiCodeParser.CheckStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ArchiCodeParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ArchiCodeParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ArchiCodeParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ArchiCodeParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(ArchiCodeParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#orExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(ArchiCodeParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(ArchiCodeParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#andExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(ArchiCodeParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(ArchiCodeParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(ArchiCodeParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(ArchiCodeParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(ArchiCodeParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#addSubExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(ArchiCodeParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#addSubExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(ArchiCodeParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#mulDivExpr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(ArchiCodeParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#mulDivExpr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(ArchiCodeParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(ArchiCodeParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(ArchiCodeParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(ArchiCodeParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(ArchiCodeParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(ArchiCodeParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(ArchiCodeParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterFloatExpr(ArchiCodeParser.FloatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitFloatExpr(ArchiCodeParser.FloatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(ArchiCodeParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(ArchiCodeParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterCharExpr(ArchiCodeParser.CharExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitCharExpr(ArchiCodeParser.CharExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolTrueExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBoolTrueExpr(ArchiCodeParser.BoolTrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolTrueExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBoolTrueExpr(ArchiCodeParser.BoolTrueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolFalseExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBoolFalseExpr(ArchiCodeParser.BoolFalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolFalseExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBoolFalseExpr(ArchiCodeParser.BoolFalseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stepExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStepExpr(ArchiCodeParser.StepExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stepExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStepExpr(ArchiCodeParser.StepExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(ArchiCodeParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(ArchiCodeParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(ArchiCodeParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(ArchiCodeParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(ArchiCodeParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(ArchiCodeParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArchiCodeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ArchiCodeParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArchiCodeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ArchiCodeParser.TypeContext ctx);
}