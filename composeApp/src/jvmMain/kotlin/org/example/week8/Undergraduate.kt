class Undergraduate (id: String, name: String, course: String) : Student(id, name, course){

    override fun getGrade(): String {
        return when(mark) {
            in 70..100 -> "First"
            in 60..69 -> "2/1"
            in 50..59 -> "2/2"
            in 40..49 -> "Third"
            else -> "Fail"
        }
    }
}