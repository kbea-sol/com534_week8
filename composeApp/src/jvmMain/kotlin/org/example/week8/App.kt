package org.example.week8

import Student
import Undergraduate
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import week8.composeapp.generated.resources.Res
import week8.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    studentApp()
}

@Composable
fun studentApp(){
    var studentList = remember{mutableStateListOf<Student>()}
    Row{
        studentAdd() {studentList.add(it)}
        Spacer(Modifier.width(10.dp))
        studentDisplay(studentList)
    }
}

@Composable
fun studentDisplay(studentSnapshot : SnapshotStateList<Student>){
    Column {
        studentSnapshot.forEach {
            Text("ID: ${it.id}\nName: ${it.name}\nCourse: ${it.course}")
            Spacer(Modifier.height(32.dp))
        }

    }
}

@Composable
fun studentAdd(onStudentAdded : (Student) -> Unit){

    var studentID = remember{mutableStateOf("")}
    var studentName = remember{mutableStateOf("")}
    var course = remember{mutableStateOf("")}

    Row {
        Column {
            OutlinedTextField(
                value = studentID.value, label = { Text("Student ID") },
                singleLine = true, onValueChange = { studentID.value = it })
            OutlinedTextField(
                value = studentName.value, label = { Text("Student Name") },
                singleLine = true, onValueChange = { studentName.value = it })
            OutlinedTextField(
                value = course.value, label = { Text("Course") },
                singleLine = true, onValueChange = { course.value = it })
            Button(
                { onStudentAdded(Undergraduate(studentID.value, studentName.value, course.value)) },
                content = { Text("Add student") })

        }
    }
}