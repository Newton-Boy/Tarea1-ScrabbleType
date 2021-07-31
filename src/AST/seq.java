package AST;

import TiposScrabble.Scrabble;

import java.util.ArrayList;
import java.util.List;
/**
 * Composite del AST, para resolver las
 * */
public class seq implements AST {
    private List<AST> ast=new ArrayList<AST>();
    @Override
    public List<AST> getList() {
        List<AST> L=new ArrayList<AST>();
        for (AST a: ast){
            L.add(a);
        }
        return L;
    }
    /**
     * add del Composite. Añade un nuevo AST a la Lista de AST.
     * @param Ast
     */
    public void add(AST Ast){
        ast.add(Ast);
    }
    /**
     * remove del Composite. Remueve un AST de la Lista de AST.
     * @param Ast
     */
    public void remove(AST Ast){
        ast.remove(Ast);
    }
    /**
     * getChild del Composite. Devuelve el AST en el indice
     * i dentro de la Lista de AST.
     * @param i
     */
    public AST getChild(int i){
        return ast.get(i);
    }
}
