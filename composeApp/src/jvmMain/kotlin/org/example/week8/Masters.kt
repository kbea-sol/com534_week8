class Masters (id: String, name: String, course: String) : Student(id, name, course){

    override fun getGrade(): String {
        return when(mark) {
            in 70..100 -> "Distinction"
            in 50..69 -> "Merit"
            in 40..49 -> "Pass"
            else -> "Fail"
        }
    }
}