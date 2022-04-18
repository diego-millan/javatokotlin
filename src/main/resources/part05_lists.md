# Listas

Na sessão de Listas, o Kotlin reutiliza a estrutura do Java de Lists e Collections, e adiciona o tipo **Mutable** para todos, o que torna a manipulação de listas um trabalho mais fácil na hora de separar coleções imutáveis e mutáveis.

Diagrama da própria documentação do Kotlin:

![Kotlin collection interfaces](C:\Users\diego.rodrigo.millan\workspaces\kotlin\javatokt\src\main\resources\images\collections-diagram.png)

### Lists

Com a separação de lists e mutable lists do Kotlin, podemos criar uma lista já informando que ela pode ser modificada através de MutableLists.

```kotlin
@Test
fun `when use add to mutable list then it should add the item in the end`(){
    val mutableStringList = mutableListOf<String>()
    mutableStringList.add("item1")
    mutableStringList.add("item2")

    Assertions.assertEquals("item1", mutableStringList[0])

    mutableStringList.remove("item1")
    Assertions.assertEquals("item2", mutableStringList[0])
}

@Test
fun `when use list and try to change it then it should not compile`() {
    val list: List<String> = listOf("a", "b")
    list.add("c") // compile error
}
```

No link abaixo está a documentação oficial para mais operações específicas das mutable lists:
[Kotlin Collections Documentation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/)

### Maps

Um pouco diferente do Java, para adicionar itens a um map mutável, podemos fazer de duas formas, como mostra o exemplo abaixo:

```kotlin
@Test
fun `when use add and remove to mutable map then it should work properly`(){
    val mutableMap : MutableMap<String, Int> = mutableMapOf("a" to 1, "b" to 2, "c" to 3)
    mutableMap["d"] = 4
    mutableMap.remove("c")

    Assertions.assertEquals(1, mutableMap["a"])
    Assertions.assertEquals(4, mutableMap["d"])
    Assertions.assertFalse(mutableMap.containsKey("c"))
}

```

Podemos adicionar elementos usando o **_mutableMapOf_** na inicialização do Map no formato Key **_to_** Value.

Podemos adicionar após a inicialização do objeto utilizando o exemplo da linha de baixo, Map [Chave] = Valor.

E para remover do Map, utilizamos a chave para encontrar e excluir o elemento.

### Sets

Como já vimos a forma correta de inserir elementos, inicializar Maps e Lists, os Sets não devem ter tanta novidade, vamos ao exemplo:

```kotlin
val intMutableSet = mutableSetOf<Int>(2, 6, 4, 29, 4, 5)  
val anyMutableSet: Set<Any> = setOf(2, 6, 4, 29, 4, 5, "Ajay", "Ashu", "Ajay")
```

A diferença entre Set, Map e List são as mesmas que temos no Java, abaixo um link para fixar o tema:

[Map Set and List](https://www.w3schools.blog/list-set-map-java)

