<template>
    <div>
        <div v-if="!submitted">
            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <input type="text" class="form-control" id="title" required name="title" v-model="todo.title">
            </div>
            <div class="mb-3">
                <label for="day" class="form-label">Day</label>
                <input type="text" class="form-control" id="day" required name="day" v-model="todo.day">
            </div>
            <div class="mb-3">
                <label for="time" class="form-label">Time</label>
                <input type="time" class="form-control" id="time" required name="time" v-model="todo.time">
            </div>
            <div class="mb-3">
                <button @click="saveTodo" class="btn btn-primary">Submit</button>
            </div>
        </div>
        <div v-else>
            <div class="alert alert-success" role="alert">
                Save todo successfully!
            </div>
            <button @click="newTodo" class="btn btn-primary">Add New Todo</button>
        </div>
    </div>
</template>

<script>
import TodoDataService from '@/service/TodoDataService'

export default {
    name: 'add-todo',
    data() {
        return {
            todo: {
                id: null,
                title: "",
                day: "",
                time: "",
            },
            submitted: false
        }
    },
    methods: {
        saveTodo() {
            var data = {
                title: this.todo.title,
                day: this.todo.day,
                time: this.todo.time

            }
            TodoDataService.create(data)
                .then(response => {
                    this.todo.id = response.data.id
                    this.submitted = true;
                })
                .catch( e => {
                    alert(e)
                })
        },
        newTodo() {
            this.submitted = false
            this.todo = {}
        }
    }
}
</script>