Vue.component('todo-item', {
    props: ['todo'],
    template: '<li>{{ todo.text }}</li>'
})

var app = new Vue({
    el: '#app',
    beforeCreate:{

    },
    data: {
        product: 'Boots',
        sample: 'cosmetics',
        message: '이 페이지는' + new Date() + '에 로드 되었습니다.',
        seen: true,
        todos: [
            {text: 'JavaScript 배우기'},
            {text: 'Vue 배우기'},
            {text: '무언가 멋진 것을 만들기'}
        ],
        message2: '안녕하세요',
        message3: 'v-model',

        groceryList: [
            { id: 0, text: 'Vegetables' },
            { id: 1, text: 'Cheese' },
            { id: 2, text: 'Whatever else hubans are supposed to eat' }
        ],

    },
    methods: {
        reverseMessage: function(){
            this.message2 = this.message2.split('').reverse().join('')
        }
    }
})