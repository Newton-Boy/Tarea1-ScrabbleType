package AST;

import TiposScrabble.Operadores.AddScrabble;
import TiposScrabble.LogicScrabble;
import TiposScrabble.Number.NumberScrabble;
import TiposScrabble.Scrabble;
import Visitors.*;
/**
 * Client es una clase que existe para la implementación de los métodos del
 * patron de diseño Visitor.
 */
public class Client {
    private seq Seq;
    /**
     * Constructor de Client, genere una "secuencia" seq
     * vacia, o en otras palabras, setea un nuevo AST vacio
     */
    public Client(){
        Seq= new seq();
    }
    /**
     * add agrega nuevos AST a la lista de Seq
     */
    public void add(AST ast){
        Seq.add(ast);
    }
    /**
     * Implementación del método visitante Add
     * @param Sc1,Sc2
     */
    public AddScrabble getAdd(Scrabble Sc1, Scrabble Sc2){
        Add v= new Add();
        Sc1.accept(v,Sc2);
        return v.getResult();
    }
    /**
     * Implementación del método visitante And
     * @param Sc1,Sc2
     */
    public LogicScrabble getAnd(LogicScrabble Sc1,LogicScrabble Sc2){
        And v=new And();
        Sc1.accept(v,Sc2);
        return v.getResult();
    }
    /**
     * Implementación del método visitante Division
     * @param Sc1,Sc2
     */
    public NumberScrabble getDivision(Scrabble Sc1,Scrabble Sc2){
        Division v=new Division();
        Sc1.accept(v,Sc2);
        return v.getResult();
    }
    /**
     * Implementación del método visitante Or
     * @param Sc1,Sc2
     */
    public LogicScrabble getOr(LogicScrabble Sc1,LogicScrabble Sc2){
        Or v=new Or();
        Sc1.accept(v,Sc2);
        return v.getResult();
    }
    /**
     * Implementación del método visitante Product
     * @param Sc1,Sc2
     */
    public NumberScrabble getProduct(Scrabble Sc1,Scrabble Sc2){
        Product v=new Product();
        Sc1.accept(v,Sc2);
        return v.getResult();
    }
    /**
     * Implementación del método visitante Sub
     * @param Sc1,Sc2
     */
    public NumberScrabble getSub(Scrabble Sc1,Scrabble Sc2){
        Sub v=new Sub();
        Sc1.accept(v,Sc2);
        return v.getResult();
    }
}
