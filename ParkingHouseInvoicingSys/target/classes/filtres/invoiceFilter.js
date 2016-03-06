 app.filter("asDate", function () {
     return function (input) {
         return new Date(input);
     }
 });
 
 app.filter('setDecimal', function ($filter) {
	    return function (input, places) {
	        if (isNaN(input)) return input;
	        var factor = "1" + Array(+(places > 0 && places + 1)).join("0");
	        return Math.round(input * factor) / factor;
	    };
	});

