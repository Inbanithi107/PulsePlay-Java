<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    .container{
        display: flex;
        align-items: center;
        justify-content: center;
        height: 500px;
        flex-direction: column;
        border: 3px solid rgb(7, 138, 226);
        margin-left: 80px;
        margin-right: 80px;
        margin-top: 60px;
    }
    p{
        font-size: larger;
    }
    button{
        color: white;
        background-color: rgb(25, 107, 201);
    }
    
</style>
<body>
    <div class="container">
        <h1 style="font-size: xxx-large; color: red;">Pulse Play</h1>
        <p>Hi ${Name} , Thankyou for choosing pulse play Watch Unlimited Movies
            And Tv Shows on our websites  </p><br>
        <p>This is a Otp Verfication Mail from Pulse Play</p><br>
        <p>Please Enter The Otp On Your Screen To Complete Registration 
        </p>    <br>
        <p>The OTP is <button>${otp}</button></p>
    </div>
</body>
</html>