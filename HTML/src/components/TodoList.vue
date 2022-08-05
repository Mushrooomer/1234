<template>
    <div>
        <table class="table">
            <thead>
                <tr>
                <th scope="col">Title</th>
                <th scope="col">Day</th>
                <th scope="col">Time</th>
                <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody v-for="(todo, index) in todos" :key="index">
                <tr>
                    <td>{{todo.title}}</td>
                    <td>{{todo.day}}</td>
                    <td>{{todo.time}}</td>
                    <td><a :href="'/todos/' + todo.id" class="btn btn-primary">Edit</a></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>

import TodoDataService from '@/service/TodoDataService'

export default {
    name: 'TodoList',
    data() {
        return {
            todos: []
        }
    },
    methods: {
        retrieveTodos() {
            TodoDataService.getAll()
                .then(response => {
                    this.todos = response.data
                })
                .catch(e => {
                    alert(e)
                })
        }
    },
    mounted() {
        this.retrieveTodos()
    }
}
</script>