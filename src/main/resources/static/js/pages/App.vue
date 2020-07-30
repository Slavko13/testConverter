<template>
    <div>
    <div class="container-fluid">
        <div id="logout">{{profile.name}}&nbsp;<a href="/logout">Выйти</a></div>
        <h3>Конвертатор валют by Slavko-</h3>
        <valutes-list :valutes="valutes" :history="history" :lastQuery="lastQuery" :valuteAttr="lastQuery" />
        <history-list :history="history" :historyForSearch="historyForSearch" :valutes="valutes"/>
        </div>
    </div>
</template>

<script>
    import ValutesList from 'components/ValutesList.vue'
    import HistoryList from 'components/HistoryList.vue'
    export default {
        components: {
            ValutesList,
            HistoryList
        },
        data() {
            return {
                valutes: frontendData.valute,
                profile: frontendData.profile,
                history: frontendData.history,
                historyForSearch: [],
                lastQuery: [{id: 0, sourceValute: 0, targetValute: 0, sourceValuteValue: 0, targetValuteValue: 0}]
            }
        }
    }
</script>

<style>

</style>