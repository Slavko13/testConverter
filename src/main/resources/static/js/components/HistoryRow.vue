<template>
    <tr>
    <td>{{historyItem.id}}</td>
    <td>{{historyItem.sourceValute}}</td>
    <td>{{historyItem.targetValute}}</td>
    <td>{{historyItem.sourceValuteValue}}</td>
    <td>{{historyItem.targetValuteValue}}</td>
    <td>{{historyItem.localDate}}</td>
    </tr>
</template>

<script>
    export default {
        props: ['historyItem', 'history']
    }
</script>

<style>

</style>