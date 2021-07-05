function getNickname(defaultValue = "Guest") {
    const readNickName = sessionStorage.getItem('Nickname') || prompt('Digite seu nick:');
    sessionStorage.setItem('Nickname', readNickName || defaultValue);
    return sessionStorage.getItem('Nickname');
}

export {getNickname}