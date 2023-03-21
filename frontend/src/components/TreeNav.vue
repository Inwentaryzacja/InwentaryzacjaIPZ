<script setup lang="ts">

</script>

<template>
    <div class="box">
        <div class="tools">
            <div class="option" id="add">
                +
            </div>
            <div class="option" id="del">
                -
            </div>
            <div class="option" id="arrowUp">
                u
            </div>
            <div class="option" id="arrowDown">
                d
            </div>
        </div>

        <div class="elements">
            
        </div>
    </div>
</template>

<style scoped>
.box{
    width: 400px;
    height: 100%;
    border-right: solid rgba(0, 0, 0) 1px;
    font-family: Arial;
}

.tools{
    width: 100%;
    height: 70px;
    background-color: #D4D4D4;
    text-align: center;
    font-size: 40px;
}

.option{
    width: 50px;
    height: 50px;
    background-color: #0082FB;
    color: white;
    border: solid black 1px;
    border-radius: 5px;
    display: inline-block;
    margin: 24px;
    margin-top: 8px;
}

span{
    color: #0082FB;
    font-family: Arial;
    font-size: 24px;
    margin: 135px;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
}
</style>