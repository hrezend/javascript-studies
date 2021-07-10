const isExistsLocalStorage = (key) => localStorage.getItem(key) != null;
const createOrEditLocalStorage = (key, value) => localStorage.setItem(key, JSON.stringify(value));
const getValueFromLocalStorage = (key) => JSON.parse(localStorage.getItem(key));
const getStyle = (element, style) => window.getComputedStyle(element).getPropertyValue(style);

const html = document.querySelector("html");
const checkbox = document.querySelector("input[name=theme]");

const lightColors = {
    colorBackground: getStyle(html, "--color-background"),
    colorPanel: getStyle(html, "--color-panel"),
    colorText: getStyle(html, "--color-text"),
    colorHeadings: getStyle(html, "--color-headings"),
    colorInfo: getStyle(html, "--color-info"),
}

const darkColors = {
    colorBackground: getStyle(html, "--dcolor-background"),
    colorPanel: getStyle(html, "--dcolor-panel"),
    colorText: getStyle(html, "--dcolor-text"),
    colorHeadings: getStyle(html, "--dcolor-headings"),
    colorInfo: getStyle(html, "--dcolor-info"),
}

const transformKey = key => "--" + key.replace(/([A-Z])/, "-$1").toLowerCase();

const changeColors = (colors) => {
    Object.keys(colors).map(key => 
        html.style.setProperty(transformKey(key), colors[key]) 
    );
}

checkbox.addEventListener("change", ({target}) => {
    if(target.checked){
        changeColors(darkColors);
        createOrEditLocalStorage('theme','darkColors')
    }
    else{
        changeColors(lightColors);
        createOrEditLocalStorage('theme','lightColors')
    }
});

if(!isExistsLocalStorage('theme')){
    createOrEditLocalStorage('theme', 'lightColors');
}

if(getValueFromLocalStorage('theme') === "lightColors"){
    checkbox.removeAttribute('checked');
    changeColors(lightColors);
} 
else{
    checkbox.setAttribute('checked', "");
    changeColors(darkColors);
}