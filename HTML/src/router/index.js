import { createWebHistory, createRouter } from "vue-router";

import AddTodo from '@/components/AddTodo'
import EditTodo from '@/components/EditTodo'
import TodoList from '@/components/TodoList'

var router = createRouter({
  history: createWebHistory(),
  routes: [
        {
            path: '/',
            alias: '/todos',
            name: 'todos',
            component: TodoList
        },

        {
            path: '/todos/:id',
            name: 'edit-todo',
            component: EditTodo
        },
        {
            path: '/add',
            name: 'add-todo',
            component: AddTodo
        }

  ]
});

export default router;