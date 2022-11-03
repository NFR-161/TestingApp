package com.exampleone.testingapp.data

import com.github.javafaker.Faker

class Repository {
    private val faker = Faker()
    private val photoUrl = listOf(
        "https://vse-footbolki.ru/image/cache/catalog/vsm/0/2/2323/2323771/previews/people_1_pad_front_white_700-280x280.jpg",
        "https://uprostim.com/wp-content/uploads/2021/03/image086-77.jpg",
        "https://mir-s3-cdn-cf.behance.net/user/276/73a970837808551.60dac5a7d9a3c.jpg",
        "https://coolsen.ru/wp-content/uploads/2021/09/184.jpg",
        "https://coolsen.ru/wp-content/uploads/2021/06/138-8.jpg",
        "https://drasler.ru/wp-content/uploads/2019/10/%D0%A1%D0%BA%D0%B0%D1%87%D0%B0%D1%82%D1%8C-%D0%BA%D1%80%D1%83%D1%82%D1%8B%D0%B5-%D0%B8-%D0%BB%D1%83%D1%87%D1%88%D0%B8%D0%B5-%D1%84%D0%BE%D1%82%D0%BE-%D0%BD%D0%B0-%D0%B0%D0%B2%D0%B0%D1%82%D0%B0%D1%80%D0%BA%D1%83-%D0%B2-%D0%B2%D0%BA-%D0%B4%D0%BB%D1%8F-%D0%BF%D0%B0%D1%86%D0%B0%D0%BD%D0%BE%D0%B2014.jpg",
        "https://sankt-peterburg.vse-footbolki.ru/image/cache/catalog/vsm/0/1/1925/1925159/previews/people_1_sign_front_white_700-280x280.jpg",
        "https://placepic.ru/wp-content/uploads/2021/02/kinopoisk_ru_Brad_Pi-41.jpg",
        "https://i.pinimg.com/280x280_RS/56/4e/5f/564e5ff55817527e72df9816392f411e.jpg",
        "https://imagetext2.ru/pics_max/imagetext_ru_27626.jpg"
    )

    fun getPersonList(): List<User> {
        var counter = 0
        val list = mutableListOf<User>()
        for (i in 1..40) {
            if (counter < 9) {
                list.add(
                    User(
                        id = i,
                        enabled = true,
                        name = faker.name().name(),
                        picUrl = photoUrl[counter]
                    )
                )
                counter++
            } else {
                list.add(
                    User(
                        id = i,
                        enabled = true,
                        name = faker.name().name(),
                        picUrl = photoUrl[counter]
                    )
                )
                counter = 0
            }
        }
        return list
    }
}