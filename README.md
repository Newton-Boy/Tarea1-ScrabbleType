# Tarea3

En principio explicaré comó funciona el código como un todo y no ahondare en los métodos usados (salvo que sea realmente necesario) pues estos ya estan propiamente documentados. Este Documento irá actualizandoce en la medida que la Tarea entregada se modifique.

Scrabble
=================================
**Scrabble** es un objeto que debiera poder replicar algunas operaciónes y propiedades que contienen los tipos primitivos (*String, Boolean, Float, Integer, y Bin*) que se encuentran integrados en Java. Las interfaces **Scrabble** definen distintas instancias de un tipo Scrabble (como `LogicScrabble` e `IntBinScrabble`, definen a `BinaryScrabble`) o proveen de operaciones que no todos los tipos **Scrabble** deben compartir (`AddScrabble` excluye a `BoolScrabble`, dado a que este no debe ser capaz de sumar u concatenar, mas si puede ser concatenado por medio de un `StringScrabble`).

## Interfaces de Scrabble:
1. `Scrabble` es la interface de la cual todas las demás, incluyendo las clases creadas, se pueden identificar como un **Tipo Scrabble**. Los métodos que propone son usados por todas las clases.
2. `AddScrabble` extiende de `Scrabble` directamente y añade el método Suma, el cual permite sumar o concatenar los parametros de un **Tipo Scrabble**. Solo la clase `BoolScrabble` no se beneficia de este.
3. `NumberScrabble` extiende de `AddScrabble` y otorga la mayoria de las operaciones que cada **Tipo Scrabble** con un parametro numérico debiera realizar, incluyendo `BinaryScrabble` que tiene contiene un *String* binario como parametro, pero carece de las operaciónes compartidas entre `IntScrabble` y `BinaryScrabble`. *Suma, Resta, Producto, División, Opuesto, e Inverso* son operaciones que caracterizan esta interfaz.
4. `IntBinaryScrabble` extiende de `NumberScrabble` y existe solo para poder definir métodos especiales que solo deben existir entre `IntScrabble` y `BinaryScrabble`.
5. `LogicScrabble` extiende de `Scrabble` directamente, define a los **Tipo Scrabble** que tienen valores de verdad. En su contrato promete las operaciones O lógicas e Y lógicas y negación lógica.

## Clases Scrabble:
* `AbstractNumberScrabble` es una **clase abstracta** que implementa la interfaz `NumberScrabble`. Reduce la duplicación de codigo al realizar métodos que definen las operaciones *Suma, Resta, Producto, y División* que promete `NumberScrabble`. Por desgracía tales métodos no pueden ser aplicados directamente a `BinaryScrabble` dado a que el constructor exige un tipo *Number*, mientras que este Scrabble recibe un *String*.
* `StringScrabble` es una clase que implementa `AddScrabble`, y recibe como parametro un tipo *String*. Define los metodos Suma (Concatenación) en ella.
* `BoolScrabble` es una clase que implementa `LogicScrabble`, y recibe como parametro un tipo *Boolean*. Define los métodos de las operaciones logicas otorgadas por su respectiva interfaz, devolviendo un `BoolScrabble` si se opera con otro, y un `BinaryScrabble` si se opera con un Scrabble de parametro binario.
* `FloatScrabble`es una clase que extiende `AbstractNumberScrabble`, y recibe como parametro un tipo *Double*. Hereda los métodos de las operaciones numéricas definidas en la clase padre, ejecutadas tal que retornan un `FloatScrabble` como resultado de estas operaciones.
* `IntScrabble` es una clase de parametros *Integer* que extiende de `AbstractNumberScrabble` e implementa `IntBinaryScrabble`. Hereda los métodos de las operaciones numéricas definidas en la clase padre, ejecutadas tal que retornan un `IntScrabble` como resultado de estas operaciones. Además, define los métodos de las transformaciones a `BinaryScrabble` y las operaciones de *Suma, Resta, Producto y División* con este **Tipo Scrabble**.
* `BinaryScrabble` es una clase que implementa tanto `IntBinaryScrabble`como `LogicScrabble`, que toma como parametro un *String* binario. En este, se definen los métodos de las operaciones numéricas y lógicas de cada interfaz respectivamente.

## Patron Flyweigth
En este código existe para cada uno de los tipos de las clases Scrabble una *"Fábrica"* de dichas clases (Creo que debiera existir una forma de reducir cogido al respecto, pero no he logrado encontrar una forma cómoda), con el cual es posible generar varias variables iguales sin consumir tanta memoría.

## Operaciones:
Existen en el Main, métodos estáticos que necesitan un trabajo para ser refinados (y al ser estáticos no pueden ser testeados con facilidad), que representan las operaciones *Add, Sub, Product, Division, Or, y And* todas estas toman 2 parametros Scrabble y retornan un tipo Scrabble. Además existe un método Ejemplo que imprime el resultado de alguna combinación de operaciones.
