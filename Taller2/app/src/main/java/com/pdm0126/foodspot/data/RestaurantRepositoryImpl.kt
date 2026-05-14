package com.pdm0126.foodspot.data
import com.pdm0126.foodspot.model.Dish
import com.pdm0126.foodspot.model.Restaurant

class RestaurantRepositoryImpl : RestaurantRepository{
    override fun getRestaurants(): List<Restaurant> {
        return listOf(

            Restaurant(
                id = 1,
                name = "Pizza Palace",
                description = "Las mejores pizzas artesanales",
                imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591",
                categories = listOf("Italiana"),
                menu = listOf(
                    Dish(1, "Pizza Margarita", "Clásica con albahaca", "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38"),
                    Dish(2, "Pizza Pepperoni", "Con pepperoni", "https://images.unsplash.com/photo-1534308983496-4fabb1a015ee"),
                    Dish(3, "Pizza BBQ", "Salsa BBQ", "https://images.unsplash.com/photo-1601924582975-7e5c8c6e9c91")
                )
            ),

            Restaurant(
                id = 2,
                name = "Burger House",
                description = "Hamburguesas jugosas",
                imageUrl = "https://images.unsplash.com/photo-1550547660-d9450f859349",
                categories = listOf("Comida Rápida"),
                menu = listOf(
                    Dish(4, "Cheeseburger", "Con queso", "https://images.unsplash.com/photo-1550547660-d9450f859349"),
                    Dish(5, "Bacon Burger", "Con tocino", "https://images.unsplash.com/photo-1553979459-d2229ba7433b"),
                    Dish(6, "Double Burger", "Doble carne", "https://images.unsplash.com/photo-1568901346375-23c9450c58cd")
                )
            ),

            Restaurant(
                id = 3,
                name = "Sushi World",
                description = "Auténtico sushi japonés",
                imageUrl = "https://images.unsplash.com/photo-1546069901-ba9599a7e63c",
                categories = listOf("Asiática"),
                menu = listOf(
                    Dish(7, "Sushi Roll", "Roll fresco", "https://images.unsplash.com/photo-1553621042-f6e147245754"),
                    Dish(8, "Tempura", "Crujiente", "https://images.unsplash.com/photo-1604908176997-125f25cc6f3d"),
                    Dish(9, "Ramen", "Caliente", "https://images.unsplash.com/photo-1605478038751-0a62c1c0fcd2")
                )
            ),

            Restaurant(
                id = 4,
                name = "Healthy Life",
                description = "Comida saludable",
                imageUrl = "https://images.unsplash.com/photo-1498837167922-ddd27525d352",
                categories = listOf("Saludable"),
                menu = listOf(
                    Dish(10, "Ensalada", "Fresca", "https://images.unsplash.com/photo-1550304943-4f24f54ddde9"),
                    Dish(11, "Bowl", "Nutritivo", "https://images.unsplash.com/photo-1546069901-ba9599a7e63c"),
                    Dish(12, "Smoothie", "Natural", "https://images.unsplash.com/photo-1505253216365-3f4c5a2c1b0e")
                )
            ),

            Restaurant(
                id = 5,
                name = "Sweet Desserts",
                description = "Postres deliciosos",
                imageUrl = "https://images.unsplash.com/photo-1551024506-0bccd828d307",
                categories = listOf("Postres"),
                menu = listOf(
                    Dish(13, "Pastel", "Chocolate", "https://images.unsplash.com/photo-1578985545062-69928b1d9587"),
                    Dish(14, "Cupcake", "Vainilla", "https://images.unsplash.com/photo-1599785209707-28c6b1c4f0b3"),
                    Dish(15, "Helado", "Fresa", "https://images.unsplash.com/photo-1497034825429-c343d7c6a68f")
                )
            ),

            Restaurant(
                id = 6,
                name = "Coffee Spot",
                description = "Café premium",
                imageUrl = "https://images.unsplash.com/photo-1509042239860-f550ce710b93",
                categories = listOf("Bebidas"),
                menu = listOf(
                    Dish(16, "Latte", "Cremoso", "https://images.unsplash.com/photo-1511920170033-f8396924c348"),
                    Dish(17, "Capuccino", "Espumoso", "https://images.unsplash.com/photo-1509042239860-f550ce710b93"),
                    Dish(18, "Americano", "Fuerte", "https://images.unsplash.com/photo-1510627498534-cf7e9002facc")
                )
            ),

            Restaurant(
                id = 7,
                name = "Taco Fiesta",
                description = "Sabores mexicanos",
                imageUrl = "https://images.unsplash.com/photo-1600891964599-f61ba0e24092",
                categories = listOf("Mexicana"),
                menu = listOf(
                    Dish(19, "Tacos", "Tradicionales", "https://images.unsplash.com/photo-1600891964599-f61ba0e24092"),
                    Dish(20, "Burrito", "Grande", "https://images.unsplash.com/photo-1562967916-eb82221dfb36"),
                    Dish(21, "Quesadilla", "Con queso", "https://images.unsplash.com/photo-1617196038435-c9b6a6c7d429")
                )
            ),

            Restaurant(
                id = 8,
                name = "Pasta House",
                description = "Pasta italiana",
                imageUrl = "https://images.unsplash.com/photo-1525755662778-989d0524087e",
                categories = listOf("Italiana"),
                menu = listOf(
                    Dish(22, "Spaghetti", "Clásico", "https://images.unsplash.com/photo-1589308078054-8327b3f3c6b3"),
                    Dish(23, "Lasagna", "Horneada", "https://images.unsplash.com/photo-1603133872878-684f208fb84b"),
                    Dish(24, "Fettuccine", "Alfredo", "https://images.unsplash.com/photo-1588013273468-315fd88ea34c")
                )
            ),

            Restaurant(
                id = 9,
                name = "Vegan Corner",
                description = "Opciones veganas",
                imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd",
                categories = listOf("Saludable"),
                menu = listOf(
                    Dish(25, "Tofu Bowl", "Proteína vegetal", "https://images.unsplash.com/photo-1606787366850-de6330128bfc"),
                    Dish(26, "Vegan Burger", "Sin carne", "https://images.unsplash.com/photo-1600891964092-4316c288032e"),
                    Dish(27, "Salad Mix", "Variado", "https://images.unsplash.com/photo-1550304943-4f24f54ddde9")
                )
            ),

            Restaurant(
                id = 10,
                name = "Juice Bar",
                description = "Jugos naturales",
                imageUrl = "https://images.unsplash.com/photo-1497534446932-c925b458314e",
                categories = listOf("Bebidas"),
                menu = listOf(
                    Dish(28, "Orange Juice", "Natural", "https://images.unsplash.com/photo-1571687949920-9b9d7e7c9c77"),
                    Dish(29, "Green Juice", "Detox", "https://images.unsplash.com/photo-1505576399279-565b52d4ac71"),
                    Dish(30, "Berry Smoothie", "Frutas", "https://images.unsplash.com/photo-1497534446932-c925b458314e")
                )
            )
        )
    }
}