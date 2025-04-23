// Generated from C:/studia/Kompilatory/gramatyka/gramatyka/ArchiCode.g4 by ANTLR 4.13.2
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
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(ArchiCodeParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(ArchiCodeParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(ArchiCodeParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(ArchiCodeParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(ArchiCodeParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(ArchiCodeParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(ArchiCodeParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(ArchiCodeParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(ArchiCodeParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(ArchiCodeParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDivExpr(ArchiCodeParser.DivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDivExpr(ArchiCodeParser.DivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(ArchiCodeParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link ArchiCodeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(ArchiCodeParser.SubExprContext ctx);
}