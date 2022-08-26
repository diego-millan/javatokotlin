# Infix Function

No Kotlin, é possível criar funções utilizando palavras que se assemelham com linguagem natural em vez de vírgulas, dois pontos e chaves.

Essas palavras são chamadas de Infix Functions, sua finalidade é fazer com que o código se torne mais legível.

Vamos a alguns exemplos:

```kotlin
package com.drm.learning.javatokt

infix fun Int.soma(a:Int):Int = this + a
```

E o teste:

```kotlin
@Test
fun `when create a sum using infix, it should sum first int with the second`() {
    val x = 10
    val y = x soma 5
    Assertions.assertEquals(15, y)
}
```

# Extension Function

Além das funções Infix, podemos também criar funções de extensão.

Lembram do toUpperCase do Java? No Kotlin podemos criar funções personalizadas e usa-las de forma semelhante.

```kotlin
fun Number.toPowerOf(exponent: Number): Double {
    return Math.pow(this.toDouble(), exponent.toDouble())
}
```

E o teste unitário:
```kotlin
@Test
fun `when use extension function of power of a number, it should multiply by itself exponent times`() {
    val x = 3
    val result = x.toPowerOf(3)
    Assertions.assertEquals(27.0, result)
}
```

#Top-level Functions

Funções estáticas são bem comuns no Java, principalmente para os adeptos de classes utilitárias.

As funções Top-level no Kotlin são semelhantes, porém ela remove a necessidade de chamar a classe e o método explicitamente.

Utilizando a importação completa do método, a chamada da função torna a classe que possui o método utilitário apenas um detalhe de importação, vamos ao exemplo:

Em Java, temos essa função estática:
```java
public static String checkUserStatus() {
  return "Online"
} 
```
Em Kotlin poderíamos fazer dessa forma:

```kotlin
package com.drm.learning.javatokt

fun checkUserStatus(): String = "Online"
```

A sua chamada se torna mais limpa, como mostra o teste unitário:

```kotlin
import com.drm.learning.javatokt.checkUserStatus

class InfixTest {
    
    @Test
    fun `when use top-level function, it should work without needed to call method class before or instantiate it`() {
        Assertions.assertEquals("online", checkUserStatus())
    }
}
```

#Named Parameters