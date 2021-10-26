package com.example.mvvm_jetpack_database.data.test

import com.example.mvvm_jetpack_database.data.model.People

class PeopleInfoProvider {

    companion object {
        var peopleList = initPeopleList()

        /**
         * Initialises peopleList with dummy data
         */
        private fun initPeopleList(): MutableList<People> {
            var peoples = mutableListOf<People>()
            peoples.add(People(
                1,
                "Ray Wenderlich",
                "RW Campus",
                "228-40332240",
                "ray@razeware.com"
                ))
            peoples.add(People(
                2,
                "Mark Tremonti",
                "Alter Bridge Concert",
                "228-44012312",
                "mark@alterbridge.com"
                ))
            peoples.add(People(
                3,
                "Jeff Bezos",
                "Amazon HQ",
                "206-26622992",
                "j.bezos@amazon.com"
                ))
            peoples.add(People(
                4,
                "Mark Zuckerberg",
                "Facebook",
                "228-41124312",
                "mark@facebook.com"
                ))
            peoples.add(People(
                5,
                "Bil Gates",
                "Microsoft HQ",
                "206-24541837",
                "gates@microsoft.com",
                ))
            peoples.add(People(
                6,
                "Tim Cook",
                "Apple, Cupertino",
                "310-27753123",
                "cook@apple.com",
                ))
            peoples.add(People(
                7,
                "Sundar Pichai",
                "Google CA",
                "310-46645322",
                "s.pichai@gmail.com",
                ))
            peoples.add(People(
                8,
                "Elon Musk",
                "SpaceX Campus",
                "310-35666875",
                "musk@spacex.com",
                ))
            return peoples
        }
    }
}
