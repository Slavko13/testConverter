<template>
    <div>
    <div v-if="this.historyForSearch==0" >
        <h3> История </h3>
        <div class="searchForm">
            <select v-model="sourceValuteForSearch">
                <option v-for="valute in valutes"  :value="valute.name">{{valute.name}}</option>
                </select>
            <select style="margin-left: 50px" v-model="targetValuteForSearch">
                <option v-for="valute in valutes" selected  :value="valute.name">{{valute.name}}</option>
                </select>
            <input type="date" id="start" name="trip-start" v-model="dateForSearch" style="margin-left: 10px">
            </div>
        <table class="table table-striped" >
            <thead>
            <tr>
                 <td ><b>Номер запроса</b></td>
                <td ><b>Исходная валюта</b></td>
                <td><b>Целевая валюта</b></td>
                <td><b>Исходная сумма</b></td>
                <td><b>Получаемая сумма</b></td>
                <td><b>Дата</b></td>
                </tr>
            </thead>
            <tbody>
            <history-row  v-for="historyItem in history" :key="historyItem.id" :historyItem="historyItem" />
            </tbody>
            </table>
        <input type="button" class="btn btn-primary" style="position:relative" value="Поискать" @click="search" />
        </div>
    <div v-else>
        <h3> История после поиска</h3>
        <div class="searchForm">
            <select v-model="sourceValuteForSearch">
                <option v-for="valute in valutes" selected  :value="valute.name">{{valute.name}}</option>
                </select>
            <select style="margin-left: 50px" v-model="targetValuteForSearch">
                <option v-for="valute in valutes" selected :value="valute.name">{{valute.name}}</option>
                </select>
            <input type="date" id="start" name="trip-start" v-model="dateForSearch" style="margin-left: 10px">
            </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <td><b>Исходная валюта</b></td>
                <td><b>Целевая валюта</b></td>
                <td><b>Исходная сумма</b></td>
                <td><b>Получаемая сумма</b></td>
                <td><b>Дата</b></td>
                </tr>
            </thead>
            <tbody>
            <history-row  v-for="historyItem in this.historyForSearch[0]" :key="historyItem.id" :historyItem="historyItem" />
            </tbody>
            </table>

        <input type="button" class="btn btn-primary" style="position:relative" value="Поискать" @click="search"  />
        <input type="button" class="btn btn-primary" value="Очистить поиск" @click="reset" style="margin-left: 10px; margin-top: 10px"/>
        </div>
    </div>
</template>

<script>
    import HistoryRow from 'components/HistoryRow.vue'

    export default {
        components: {
          HistoryRow
        },
        props: ['history', 'valutes', 'historyForSearch'],
        data() {

            var Data = new Date();

            return {
                sourceValuteForSearch: '',
                targetValuteForSearch: '',
                sourceValuteValueForSearch: '',
                targetValuteValueForSearch: '',
                dateForSearch: '' + Data.getFullYear + "-" + Data.getMonth() + "-" + Data.getDay()

            }
        },
       methods: {
            search() {
                var history = {
                    sourceValute: this.sourceValuteForSearch,
                    targetValute: this.targetValuteForSearch,
                    localDate: this.dateForSearch
                }
                this.$resource('/valute/search').save({}, history).then(result => result.json().then(
                    data => {
                        this.historyForSearch = [];
                        this.historyForSearch.push(data);
                        if (this.historyForSearch[0].length === 0) {
                            alert('Ничего не найдено');
                        }
                        console.log(this.historyForSearch);
                    })
                )
            },
            reset: function () {
                this.historyForSearch = [];
            }

        }
    }
</script>

<style>

</style>