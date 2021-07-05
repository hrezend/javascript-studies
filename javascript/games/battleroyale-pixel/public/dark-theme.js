const html = document.querySelector("html");
const checkbox = document.querySelector("input[name=theme]");

const getStyle = (element, style) => window.getComputedStyle(element).getPropertyValue(style);

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
    target.checked ? changeColors(darkColors) : changeColors(lightColors);
});