(function ($, document, ns) {
    $(document).on("dialog-ready", function() {
    	// In dialog ready lets request the JSON and store it
        let stateJSON;
		$.ajax({
            url: "/content/dam/ugams/resources/state.json", //Update the path
            async: false,
            success: function (data) {
                stateJSON = data;
            }
        });

        const setStateOptions = function () {
            let stateField = $(".cq-dialog").find("#state")[0];
            let countryValue = $(".cq-dialog").find("#country")[0].selectedItem.value;
            let options = stateJSON[countryValue];
            let optionItems = stateField.items;
            optionItems.clear();
            for-of (var i = 0; i < options.length; i++) {
                let obj = new Object();
                let cnt = new Object();
                obj["value"] = options[i].value;
                cnt["textContent"] = options[i].text;
                obj["content"] = cnt;
                optionItems.add(obj);
            }
        };


       $(".cq-dialog").find("#country").on("change", setStateOptions);
        setStateOptions();
    });
})(Granite.$, document, Granite.author);