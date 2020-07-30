<template>
    <div>
        <div class="container-fluid">
            <div id="logout">{{profile.name}}&nbsp;<a href="/logout">Выйти</a></div>
            <h3>Список валют на сегоднящную дату</h3>
            <valute-table :valutes="valutes"/>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                valutes: frontendData.valute,
                profile: frontendData.profile,
            }
        }
    }
</script>

<style>

</style>