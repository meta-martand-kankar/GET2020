var vehicleType, index;
var charge, currencyType, USD_RATE = 71,
    YEN_RATE = 0.65;
var price = [
    [5, 100, 500],
    [10, 200, 1000],
    [20, 500, 3500]
];
var vehicleString = ['Bicycle', 'Motorcycle', 'Fourwheelers'];

/**
 * This function works on vehicle registration.
 */
function vehicleData() {
    var vehicleName = document.getElementById("vehicleName").value;
    vehicleType = document.getElementById("selectVehicleType").value;
    alert("Your Vehicle Name is " + vehicleName + " and " + vehicleType + " are Registered");
    document.getElementById("vehicleformid").style.display = "none";
    document.getElementById('planid').style.display = 'block';
    changeCurrency();
}

/**
 * This function checks for validation on form.
 */
function checkValidation() {
    var flag = 1;
    var number = "0123456789";
    var alphabet = "abcdefghijklmnopqrstuvwxyz"
    var alphabet1 = alphabet.toUpperCase();
    console.log(alphabet1);
    var name = document.getElementById('name').value;

    var email = document.getElementById("email").value;
    var contact = document.getElementById("contact").value;
    var password = document.getElementById("password").value;
    console.log(password);
    var rePassword = document.getElementById("confirmpassword").value;

    //validation for user name

    if (name.length < 2) {
        alert("Name length must greater than 2 ");
        return;
    } else {
        for (var i = 0; i < name.length; i++) {
            var check = number.indexOf(name[i]);
            if (check >= 0) {
                alert("Name doesn't contain numeric value");
                return;
            }
        }
    }

    //Validation for email
    if (email.length >= 0) {
        var at_the_rate = email.indexOf('@');
        var dot = email.indexOf('.com');
        if (at_the_rate < 0) {
            alert("email is not contain @");
            return;
        }
        if (dot != email.length - 4) {
            alert("email is not contain .com");
            return;
        }
    }

    //validation for contact number.
    if (contact.length <= 8 || contact.length > 10) {
        alert("contact is not valid");
        return;
    } else {
        for (var i = 0; i < contact.length; i++) {
            var check = alphabet.indexOf(contact[i]);
            if (check >= 0) {
                alert("Name doesn't contain alphabet");
                return;
            }
        }
    }

    //validation for password
    if (password.length < 8) {
        alert("password length must be greater than 8");
        return;
    } else {
        var upperCheck = -1,
            lowerCheck = -1,
            numberCheck = -1;
        for (var i = 0; i < password.length; i++) {
            if (upperCheck < 0)
                upperCheck = alphabet1.indexOf(password[i]);
            if (lowerCheck < 0)
                lowerCheck = alphabet.indexOf(password[i]);
            if (numberCheck < 0)
                numberCheck = number.indexOf(password[i]);
        }
        if (upperCheck < 0 || lowerCheck < 0 || numberCheck < 0) {
            alert("password contain Uppercase, lowercase and numeric letter");
            return;
        }
    }

    //validation for password confirmation
    if (rePassword != password) {
        flag = 0;
        alert("your confirm password doesn't match with password");
        return;
    } else if (flag = 1) {
        alert("Your ID is registered");
        document.getElementById("registerformid").style.display = "none";
        document.getElementById('vehicleformid').style.display = 'block';
    }
}

/**
 * This fucntion is used to generate parking pass for user.
 */
function getPass() {
    if (document.getElementById("daily").checked) {
        var payableAmount = price[index][0] * selectedTypeRate;
    } else if (document.getElementById("monthly").checked) {
        var payableAmount = price[index][1] / selectedTypeRate;
    } else if (document.getElementById("yearly").checked) {
        var payableAmount = price[index][2] / selectedTypeRate;
    }
    document.getElementById("planid").innerHTML = "<h1>You Have To Pay: " + payableAmount.toFixed(2) + " " + currencyType + "</h1>";
}

/**
 * This function is used to change pass price based on currency.
 */
function changeCurrency() {

    if (vehicleType == "Bicycle")
        index = 0;
    else if (vehicleType == "Motorcycle")
        index = 1;
    else if (vehicleType == "Fourwheelers")
        index = 2;
    currencyType = document.getElementById("selectcurrency").value;

    if (currencyType == "INR") {
        document.getElementById("dailyPriceRate").innerHTML = price[index][0] + " INR";
        document.getElementById("monthlyPriceRate").innerHTML = price[index][1] + " INR";
        document.getElementById("yearlyPriceRate").innerHTML = price[index][2] + " INR";
        selectedTypeRate = 1;
    } else if (currencyType == "USD") {
        document.getElementById("dailyPriceRate").innerHTML = (price[index][0] / USD_RATE).toFixed(2) + " USD";
        document.getElementById("monthlyPriceRate").innerHTML = (price[index][1] / USD_RATE).toFixed(2) + " USD";
        document.getElementById("yearlyPriceRate").innerHTML = (price[index][2] / USD_RATE).toFixed(2) + " USD";
        selectedTypeRate = USD_RATE;

    } else if (currencyType == "YEN") {
        document.getElementById("dailyPriceRate").innerHTML = (price[index][0] / YEN_RATE).toFixed(2) + " YEN";
        document.getElementById("monthlyPriceRate").innerHTML = (price[index][1] / YEN_RATE).toFixed(2) + " YEN";
        document.getElementById("yearlyPriceRate").innerHTML = (price[index][2] / YEN_RATE).toFixed(2) + " YEN";
        selectedTypeRate = YEN_RATE;
    }
}