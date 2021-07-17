# Tarea2

En principio explicaré comó funciona el código como un todo y no ahondare en los métodos usados (salvo que sea realmente necesario) pues estos ya estan propiamente documentados. Este Documento irá actualizandoce en la medida que la Tarea entregada se modifique.

Scrabble
=================================
Scrabble es un objeto que debiera poder replicar algunas operaciónes y propiedades que contienen los tipos primitivos (String, Boolean, Float, Integer, y Bin) que se encuentran integrados en Java. Las interfaces "Scrabble" definen distintas instancias de un tipo Scrabble (como LogicScrabble e IntBinScrabble, definen a BinaryScrabble) o proveen de operaciones que no todos los tipos Scrabble deben compartir (AddScrabble excluye a BoolScrabble, dado a que este no debe ser capaz de sumar u concatenar, mas si puede ser concatenado por medio de un StringScrabble).

## Interfaces que Implementan Scrabble:
-AddScrabble añade la propiedad de sumar o concatenarse. Solo BoolScrabble no se beneficia de este.
-NumberScrabble otorga la mayoria de las operaciones que cada Scrabble con un parametro numerico debiera realizar, incluyendo BinaryScrabble que tiene contiene un string binario como parametro, pero carece de las operaciónes compartidas entre IntScrabble y BinaryScrabble.
-IntBinaryScrabble existe solo para poder definir métodos especiales que solo deben existir entre IntScrabble y BinaryScrabble.
-LogicScrabble define a los Scrabble que tienen valores de verdad. En su contrato promete las operaciones O logicas e Y logicas.

## Clases Scrabble:
### Clase Abstracta
