<html>

<head>
    <style>
        @import 'https://fonts.googleapis.com/css?family=Prompt:400,700';
        .modal {
            /* This way it could be display flex or grid or whatever also. */
            display: block;
            /* Probably need media queries here */
            width: 600px;
            max-width: 100%;
            height: 400px;
            max-height: 100%;
            position: fixed;
            z-index: 100;
            left: 50%;
            top: 50%;
            /* Use this for centering if unknown width/height */
            transform: translate(-50%, -50%);
            /* If known, negative margins are probably better (less chance of blurry text). */
            /* margin: -200px 0 0 -200px; */
            background: white;
            box-shadow: 0 0 60px 10px rgba(0, 0, 0, 0.9);
        }
        .closed {
            display: none;
        }
        .modal-overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: 50;
            background: rgba(0, 0, 0, 0.6);
        }
        .modal-guts {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            padding: 20px 50px 20px 20px;
        }
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        ul {
            margin: 10px 0 10px 30px;
        }
        li,
        p {
            margin: 0 0 10px 0;
        }
        h1 {
            margin: 0 0 20px 0;
        }
        .modal .close-button {
            position: absolute;
            /* don't need to go crazy with z-index here, just sits over .modal-guts */
            z-index: 1;
            top: 10px;
            /* needs to look OK with or without scrollbar */
            right: 20px;
            border: 0;
            background: black;
            color: white;
            padding: 5px 10px;
            font-size: 1.3rem;
        }
        .open-button {
            border: 0;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 10px 20px;
            font-size: 21px;
        }
    </style>
</head>

<body>

    <div class="modal-overlay" id="modal-overlay"></div>
    <div class="modal" id="modal">
        <button class="close-button" id="close-button">X</button>
        <div class="modal-guts">
            <h1>Modal Example</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repudiandae expedita corrupti laudantium aperiam, doloremque explicabo ipsum earum dicta saepe delectus totam vitae ipsam doloribus et obcaecati facilis eius assumenda, cumque.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repudiandae expedita corrupti laudantium aperiam, doloremque explicabo ipsum earum dicta saepe delectus totam vitae ipsam doloribus et obcaecati facilis eius assumenda, cumque.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repudiandae expedita corrupti laudantium aperiam, doloremque explicabo ipsum earum dicta saepe delectus totam vitae ipsam doloribus et obcaecati facilis eius assumenda, cumque.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repudiandae expedita corrupti laudantium aperiam, doloremque explicabo ipsum earum dicta saepe delectus totam vitae ipsam doloribus et obcaecati facilis eius assumenda, cumque.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repudiandae expedita corrupti laudantium aperiam, doloremque explicabo ipsum earum dicta saepe delectus totam vitae ipsam doloribus et obcaecati facilis eius assumenda, cumque.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repudiandae expedita corrupti laudantium aperiam, doloremque explicabo ipsum earum dicta saepe delectus totam vitae ipsam doloribus et obcaecati facilis eius assumenda, cumque.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repudiandae expedita corrupti laudantium aperiam, doloremque explicabo ipsum earum dicta saepe delectus totam vitae ipsam doloribus et obcaecati facilis eius assumenda, cumque.</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repudiandae expedita corrupti laudantium aperiam, doloremque explicabo ipsum earum dicta saepe delectus totam vitae ipsam doloribus et obcaecati facilis eius assumenda, cumque.</p>
        </div>
    </div>
    <a id="open-button" class="open-button">Open Button</a>
    
</body>

<script>
    var modal = document.querySelector("#modal");
    var modalOverlay = document.querySelector("#modal-overlay");
    var closeButton = document.querySelector("#close-button");
    var openButton = document.querySelector("#open-button");
    closeButton.addEventListener("click", function() {
        modal.classList.toggle("closed");
        modalOverlay.classList.toggle("closed");
    });
    openButton.addEventListener("click", function() {
        modal.classList.toggle("closed");
        modalOverlay.classList.toggle("closed");
    });
</script>

</html>
