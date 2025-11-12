class University {
    val studentList = mutableListOf<Student>()

    fun addStudent(s: Student) {
        studentList.add(s)
    }

    fun findStudentById(id: String) : Student? {
        for(s in studentList) {
            if(s.id == id) {
                return s
            }
        }
        return null
    }

    fun findStudentsByCourse(course: String): List<Student> {
        val matches = mutableListOf<Student>()
        for(s in studentList) {
            if (s.course == course) {
                matches.add(s)
            }
        }
        return matches
    }
}