onload=()=>{
    const links=document.getElementsByClassName("mostrarformulario");
    //const links=document.querySelectorAll(".mostrarformulario");
    for(let link of links)
    {
        link.onclick=mostrarFormulario;
        //link.addEventListener("click",mostrarFormulario);
    }

    for(let form of document.forms)
    {
        form.onclick=(evento)=>{ evento.stopPropagation();}
    }

    document.onclick=()=>{

        const formularios= document.getElementsByClassName("modal");
        for(f of formularios)
        {
            f.className="oculto";
        }
    }
}
function mostrarFormulario(evento){
    evento.preventDefault();
    evento.stopPropagation();
    const link=evento.target;
    link.parentNode.getElementsByTagName("form")[0].className="modal";
}