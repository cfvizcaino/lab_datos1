let fs = require("fs")

console.time("tiempo: ")
fs.readfile("file_agro.txt", {encoding: "utf-8"}, function(error, file){
    if(error){
        console.log(`Error: ${error}`)
    }else{
        console.log("Datos leidos:")
        console.log(file)
        console.timeEnd("tiempo: ")
    }
})
