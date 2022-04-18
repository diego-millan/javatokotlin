# Estruturas de decisão, laços e listas

## Condições

### if e else

If/else em Kotlin não apresenta modificações em relação ao Java, a única mudança seria na possibilidade de atribuir o resultado de um if e else a uma variável, como mostra o exemplo abaixo:
```kotlin
fun getTransactionId(transactionId : String?) : String {
    
    val result = if (transactionId.isNullOrBlank()) {
        UUID.randomUUID().toString()
    } else {
        transactionId
    }
    
    return result
}
```

### When

A função when veio para evitar ifs aninhados e eliminar o switch que temos no Java, apesar de parecida com o Switch, algumas leves mudanças como a remoção da necessidade do **break** faz com que ela seja mais enxuta, vamos ao exemplo:

```java
Status responseStatus;
switch (response.getCode()) {
  case 200:
    responseStatus = Status.ALLOWED;
    break;
  case 422:
    responseStatus = Status.DENIED;
    break;
  case 404:
    responseStatus = Status.NOT_FOUND;
    log.error("Error 404 On response - TransactionId: " + transactionId);
    break;
  default:
    responseStatus = Status.UNDEFINED;
    log.error("Unexpected error on response - Code: " + response.getCode() + " TransactionId: " + transactionId);
    break;
}
```

```kotlin
val responseStatus = when (response.code()) {
    200 -> Status.ALLOWED
    422 -> Status.DENIED
    404 -> {
        Status.NOT_FOUND
        log.error("Error 404 On response - TransactionId: $transactionId")
    }
    else -> {
        Status.UNDEFINED
        log.error("Unexpected error on response - Code: ${response.code()} TransactionId: $transactionId")
    }
        
}
```

Note que o uso de { } só é necessário quando precisamos executar uma ação adicional, e o default que temos no java se transforma em _**else**_

## Laços (Loops)

### for

Utilizamos o for no Kotlin de duas formas, a primeira para percorrer listas (map, list, set), e utilizamos o **in** para isso:

```kotlin
for (item in collection) {
    print(item)
}
```

A outra forma, diferente do Java, não utilizamos o mesmo formato para criar laços de _range expressions_.

Vamos aos exemplos:

No Java, definimos a variável i, indicamos a condição de parada do loop e como o loop deve se comportar a cada iteração:
```java
for (int i = 1; i <= 3; i++) {
  System.out.println(i);  
}
```

No Kotlin as coisas são um pouco diferentes, para esse mesmo cenário escrevemos assim:

```kotlin
for (i in 1..3) {
    println(i)
}
```

Onde i é a variável, e (1..3) indica que ele deve percorrer de 1 a 3.

Se precisar adicionar uma condição adicional ao incremento, pode ser feito assim:

```kotlin
for (i in 6 downTo 0 step 2) {
    println(i)
}
```

Que é o semelhante do seguinte código no Java:
```java
for (int i = 6; i >= 0; i = i - 2) {
  System.out.println(i);  
}
```

O downTo indica que é um contador de 6 até 0, enquanto o step indica que irá pular a cada 2 índices.

### While e Do While

O Kotlin possui a mesma estrutura que temos no Java de while e do/while, conforme os exemplos abaixo:
```kotlin
while (x > 0) {
    x--
}

do {
    val y = retrieveData()
} while (y != null) // y is visible here!
```
