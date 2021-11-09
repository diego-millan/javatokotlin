# Classes, modificadores de visibilidade e data class

## Classes - Geral

Bastante parecido com o Java, o Kotlin possui vários modificadores de visibilidade, porém os construtores se tornam mais fáceis de serem utilizados

### Construtores

No Kotlin, por default, a classe possui o construtor default e o construtor com todos os atributos, sem precisar cria-lo na mão.

Note que podemos, também, inicializar com um valor default no atributo. 
```kotlin
class Pet {
    var name : String
    var gender : String
}

class Pet (gender : GenderEnum = GenderEnum.FEMALE) {
    var name : String
    var gender = gender.name
}
```

Inicializando a classe:
```kotlin
val dog : Pet = Pet(GenderEnum.MALE)
val cat = Pet(GenderEnum.FEMALE)
val butterfly : Pet = Pet() // obtém valor default
```

### Classes abstratas e subclasses

Assim como no java, temos a mesma ideia de uma classe que herda de outra classe, podemos obrigar as classes a implementar métodos abstratos ou impossibilitar a sua modificação.

No exemplo abaixo, o método **talk** é abstrato, portanto toda classe que herdar de **Pet** terá que implementar.

O método **print**, por ser final, não pode ser modificado.

```kotlin
abstract class Pet {
    lateinit var name : String
    lateinit var gender : String

    abstract fun talk() : String

    fun print() {
        println("animal name is $name and its gender is $gender")
    }
}


class Cat : Pet() {
    override fun talk()  = "meeown!"
}

class Dog : Pet(){
    override fun talk() = "woof woof!!"
}
```

Inicializando Dog and Cat:
```kotlin
@Test
fun `when check method apply then it should work like builder`() {
    val dog : Pet = Dog().apply {
        name = "barto"
        gender = "male"
    }

    Assertions.assertEquals("barto", dog.name)
}

@Test
fun `when initialize variables then it should work like Java`() {
    val cat : Pet = Cat()
    cat.name = "Florence"
    cat.gender = "female"

    Assertions.assertEquals("Florence", cat.name)
}
```

## Interfaces

As interfaces são semelhantes ao Java, basta usar a palavra-chave interface em vez de class.

Assim como no Java, as classes que implementarem a interface, terão que implementar os métodos.

As interfaces podem possuir properties também, que podem ser finais ou precisam ser implementadas pelas classes.

O método printSongs, por ser implementado em Album, não pode ser overrided pelas classes que implementam a interface.
```kotlin
interface Album {
    fun getSongs() : List<String>

    val gender : String

    fun printSongs() = println("SongList : ${this.getSongs()}")
}

class Rock : Album {

    override fun getSongs() : List<String> {
        return emptyList()
    }

    override val gender = "Rock"
}
```

## Data Class

Diferente do Java, o Kotlin trata as classes de domínio de maneira simplificada.
Além de não haver a necessidade de implementar os métodos padrões que as classes de dados possuem, também economizamos nos getters e setters.

Outra particularidade do Data Class, que à primeira vista soa um pouco estranho para os programadores java, é o fato de ser comum teremo várias implementações de data class em um mesmo arquivo.

A motivação para esse comportamento é o fato de não precisar criar várias classes para uma entidade que possui várias entidades que só existem para complementar o parent.

Vamos aos exemplos.

Data Class - Kotlin:
```kotlin
data class Person(
    val name: String,
    val address: String,
    val zipCode: String,
    val age: Int,
    val birthDate: Date
)
```

Entidade no Java:
```java
@Data
public class PersonJava {
  private String name;
  private String address;
  private String zipCode;
  private Integer age;
  private Date birthDate;
}
```

Note que no java é necessário ter ao menos uma anotação do lombok para automatizar os métodos toString(), getters, setters dos atributos e o hashCode(), enquanto o Data Class por si só já tem isso por debaixo dos panos sem necessidade de uma anotação adicional.

Também não é necessário utilizar o modificador de privacidade no Kotlin, tornando mais enxuto o código. 

Um método adicional que o Kotlin adiciona nos data classes é o copy().
Como seu nome indica, ele copia os atributos de uma instância do objeto para clonar em outro, podendo alterar alguns atributos.

```kotlin
@Test
fun `when try to copy a data class only deserved attribute must change`(){
    val person = Person(
        "Diego",
        "Rua do Hospicio, 257",
        "52041-302",
        29,
        SimpleDateFormat("dd/MM/yyyy").parse("21/01/1987")
    )

    val copiedPerson = person.copy(address = "Rua Salvador de Sá, 470")

    Assertions.assertEquals(person.address, "Rua do Hospicio, 257")
    Assertions.assertEquals(copiedPerson.address, "Rua Salvador de Sá, 470")
}
```

## Enums

