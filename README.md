# Selenium Miner

Mine the web using Selenium and pre-defined plug-ins.

Based on
- [geckodriver Docker image](https://github.com/instrumentisto/geckodriver-docker-image/)
- [geckodriver](https://github.com/mozilla/geckodriver)
- [Selenium](https://github.com/SeleniumHQ/selenium)
- [Spark](https://github.com/perwendel/spark)

## Usage

### PageSourcePlugin

```
POST http://seleniumminer:5022/mine/pagesource
Content-Type: application/json

{
    "url": "https://www.google.de"
}
```

```
curl http://seleniumminer:5022/mine/pagesource -X POST -H 'content-type: application/json' -d '{"url":"https://www.google.de"}'
```