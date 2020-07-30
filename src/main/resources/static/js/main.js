import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'
import Viewer from 'pages/Viewer.vue'

Vue.use(VueResource)

new Vue({
    el: '#app',
    render: a => a(App)
})

new Vue({
    el: '#viewer',
    render: a => a(Viewer)
})


/*
var valuteApi = Vue.resource('/valute');
var searchApi = Vue.resource('/valute/search')

Vue.component('valute-table', {
    props: ['valutes'],
    template:
        '<div>' +
        '<table class="table table-striped">' +
        '<thead>' +
        '<th>#</th>' +
        '<th>Name</th>' +
        '<th>Value(RUB)</th>' +
        '</thead>' +
        '<tbody>'+
        '<tr v-for="valute in valutes">'+
        '<td class="valute.id">{{valute.id}}</td>' +
        '<td class="valute.name">{{valute.name}}({{valute.charCode}})</td>' +
        '<td class="valute.value">{{valute.value}} Rub</td>' +
        '</tr>'+
        '</tbody>'+
        '</table>'+
        '</div>',

});








*/
