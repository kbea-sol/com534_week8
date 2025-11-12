abstract class Student(val id: String, var name: String, var course: String) {

    var mark = 0
        set(newMark) {
            if(newMark in 0..100) {
                field = newMark
            }
        }

    override fun toString(): String {
        return "$name, ID $id, is on $course, mark is $mark which is a grade of ${getGrade()}"
    }

    abstract fun getGrade() : String
}
