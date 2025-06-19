// Generated from C:/Users/szyro/IdeaProjects/pz1/ArchiCode/ArchiCode.g4 by ANTLR 4.13.2
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArchiCodeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArchiCodeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ArchiCodeParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ArchiCodeParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#coreStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoreStatement(ArchiCodeParser.CoreStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#showStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowStatement(ArchiCodeParser.ShowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#defineStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineStatement(ArchiCodeParser.DefineStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#defineCollectionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineCollectionStatement(ArchiCodeParser.DefineCollectionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#assignStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatement(ArchiCodeParser.AssignStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#requestStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRequestStatement(ArchiCodeParser.RequestStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#blueprintStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlueprintStatement(ArchiCodeParser.BlueprintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#blueprintCallStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlueprintCallStatement(ArchiCodeParser.BlueprintCallStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(ArchiCodeParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(ArchiCodeParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code repeatFixed}
	 * labeled alternative in {@link ArchiCodeParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatFixed(ArchiCodeParser.RepeatFixedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code repeatUntil}
	 * labeled alternative in {@link ArchiCodeParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatUntil(ArchiCodeParser.RepeatUntilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code repeatFor}
	 * labeled alternative in {@link ArchiCodeParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatFor(ArchiCodeParser.RepeatForContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#checkStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckStatement(ArchiCodeParser.CheckStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ArchiCodeParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ArchiCodeParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(ArchiCodeParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(ArchiCodeParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(ArchiCodeParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(ArchiCodeParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#addSubExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(ArchiCodeParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#mulDivExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(ArchiCodeParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(ArchiCodeParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpr(ArchiCodeParser.FuncCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(ArchiCodeParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatExpr(ArchiCodeParser.FloatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(ArchiCodeParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharExpr(ArchiCodeParser.CharExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolTrueExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTrueExpr(ArchiCodeParser.BoolTrueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolFalseExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFalseExpr(ArchiCodeParser.BoolFalseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stepExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStepExpr(ArchiCodeParser.StepExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(ArchiCodeParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ArchiCodeParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(ArchiCodeParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(ArchiCodeParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArchiCodeParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ArchiCodeParser.TypeContext ctx);
}