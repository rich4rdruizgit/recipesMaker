import java.lang.Integer.parseInt

// Realizado por https://platzi.com/@rich4rdruiz/

val menu = """
    Selecciona la opción deseada
    1. Hacer una recetta
    2. Ver mis receta
    3. Salir
""".trimMargin()

val menuIngredient = """
    Crear receta
    1. Agregar ingrediente
    2. Terminar receta
""".trimIndent()

val ingredients = """
    "Selecciona la lista de ingredientes"
    1. Agua
    2. Leche
    3. Carne
    4. Verduras
    5. Frutas
    6. Cereal
    7. Huevos
    8. Aceite
""".trimIndent()
val invalidInput = "Entrada invalida, solo valores 1, 2, 3"
val listIngredients = listOf<String>("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "Huevos", "Aceite")
val textRecipe = "Tu receta creada es la siguiente"
val recipeEmpty = "No tienes ingredientes en tu receta"

fun main(args: Array<String>) {

    var listArray: MutableList<String> = mutableListOf()
    end@ do {
        println(menu)
        var input: String? = readLine()
        when (input?.toInt()) {
            1 -> {
                itsDone@ do {
                    println(menuIngredient)
                    var inputSub: String? = readLine()
                    when (inputSub?.toInt()) {
                        1 -> {
                            print(ingredients)
                            var ingredient: String? = readLine()
                            listArray.add(listIngredients.get(parseInt(ingredient)))
                        }
                        2 -> break@itsDone
                        else -> println(invalidInput)
                    }
                } while (inputSub?.toInt() != 2)
            }
            2 -> {
                if (listArray.isEmpty()) {
                    println(recipeEmpty)
                } else {
                    println(textRecipe)
                    for ((index, ingredient) in listArray.withIndex()) {
                        println("$index :$ingredient")
                    }
                }
            }
            3 -> break@end
            else -> println(invalidInput)
        }
    } while (input?.toInt() != 3)
}