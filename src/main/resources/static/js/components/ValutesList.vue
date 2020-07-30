<template>
    <div>
    <div class="row">
        <div class="col-md-6">
            <label for="sourceValute">Выберете исходную валюту</label>
            <select v-model="sourceValute" id="sourceValute" name="source" style="margin-left: 10px">
                <option v-for="valute in valutes"  :value="valute.name">{{valute.name}}</option>
                </select>
            <input type="text" class="form-control" v-model="sourceValuteValue" id="sourceValuteValue" placeholder="Введите сколько нужно перевести"/>
            </div>
        <div class="col-md-6">

            <label for="targetValute" >Выберете целевую валюту</label>
            <select style="margin-left: 10px" v-model="targetValute" id="targetValute" name="target">
                <option v-for="valute in valutes"  :value="valute.name">{{valute.name}}</option>
                </select>
            <input type="text" class="form-control"  :value= "lastQuery[0].targetValuteValue" id="targetValuteValue"/>
            </div>
        <div class="text-center">
            <button type="button" class="btn btn-primary" style="margin-top: 20px" @click="convert">Конвертировать</button>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        props: ['valutes', 'lastQuery', 'history', 'valuteAttr'],
        data() {
            return {
                id: "",
                sourceValute: "",
                targetValute: "",
                sourceValuteValue: "",
                targetValuteValue:""
            }
        },
        watch: {
            valuteAttr: function (newVal, oldVal) {
                this.lastQuery.targetValuteValue = newVal.targetValuteValue
            }

        },
        methods: {
            convert() {
                var history = {sourceValute: this.sourceValute, targetValute: this.targetValute, sourceValuteValue: +this.sourceValuteValue}
                this.$resource('/valute').save({},history).then(result => result.json().then(
                    data => {
                        this.lastQuery.splice(0, 1, data)
                        this.history.push(data)
                        console.log(this.lastQuery[0].targetValuteValue)
                    })
                )
            }
        }
    }

</script>

<style>

</style>