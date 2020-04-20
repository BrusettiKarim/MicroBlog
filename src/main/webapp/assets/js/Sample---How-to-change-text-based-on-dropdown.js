// Sample by 
// Twitter: @RuprectDK
// Bootstrap Studio User: @Ruprect
// Homepage: www.ruprect.dk



var Models = {
    "Model A": {size: "100x300mm", usage: "Outdoor", colour: "Black", recyclable: "Yes"},
    "Model B": {size: "50x150mm", usage: "Indoor", colour: "Blue", recyclable: "No"},
    "Model C": {size: "25x75mm", usage: "Outdoor and Indoor", colour: "Red", recyclable: "Possibly"}
};

$('#select-model .dropdown-item').on('click', function(){
    $("#size").text(Models[this.text].size);
    $("#usage").text(Models[this.text].usage);
    $("#colour").text(Models[this.text].colour);
    $("#recyclable").text(Models[this.text].recyclable);
});