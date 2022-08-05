<template>
    <div v-if="currentTodo">
            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <input type="text" class="form-control" id="title" required name="title" v-model="currentTodo.title">
            </div>
            <div class="mb-3">
                <label for="day" class="form-label">Day</label>
                <input type="text" class="form-control" id="day" required name="day" v-model="currentTodo.day">
            </div>
            <div class="mb-3">
                <label for="time" class="form-label">Time</label>
                <input type="time" class="form-control" id="time" required name="time" v-model="currentTodo.time">
            </div>
            <div class="mb-3">
                <button @click="updateTodo" class="btn btn-primary me-3">Update</button>
                <button @click="deleteTodo" class="btn btn-danger">Delete</button>
            </div>
             <div class="alert alert-success" role="alert" v-if="message">
                {{message}}
            </div>
    </div>
</template>

<script>
import TodoDataService from '../service/TodoDataService'

export default {
    name: 'EditTodo',
    data() {
        return {
            currentTodo: null,
            message: ''
        }
    },
    methods: {
        getTodo(id) {
            TodoDataService.get(id)
                .then(response => {
                    this.currentTodo = response.data
                })
                .catch(e => {
                    alert(e)
                })
        },
        updateTodo() {
            TodoDataService.update(this.currentTodo.id, this.currentTodo)
                .then(() => {
                    this.message = 'The todo was updated successfully!'
                })
                .catch(e => {
                    alert(e)
                })
        },
        deleteTodo() {
            TodoDataService.delete(this.currentTodo.id)
                .then(() => {
                    this.$router.push({name: 'todos'})
                })
                .catch(e => {
                    alert(e)
                })
        }
    },
    mounted() {
        this.getTodo(this.$route.params.id)
    }
}
</script>