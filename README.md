# GrandLeague
<br/>
<p align="center">
  <a href="https://github.com/markoeltiger/GrandLeague">
    <img src="https://b.fssta.com/uploads/application/soccer/competition-logos/EnglishPremierLeague.vresize.350.350.medium.0.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">GrandLeague</h3>

  <p align="center">
    A cool modern football application to display matches in PremierLeague build with (Compose UI , ,Roomcoroutine ,retrofit ,MVVM Architecture , LiveData)
    <br/>
    <br/>
    <a href="https://github.com/markoeltiger/GrandLeague"><strong>Explore the docs »</strong></a>
    <br/>
    <br/>
    <a href="https://github.com/markoeltiger/GrandLeague">View Demo</a>
    .
    <a href="https://github.com/markoeltiger/GrandLeague/issues">Report Bug</a>
    .
    <a href="https://github.com/markoeltiger/GrandLeague/issues">Request Feature</a>
  </p>
</p>

![Downloads](https://img.shields.io/github/downloads/markoeltiger/GrandLeague/total) ![Contributors](https://img.shields.io/github/contributors/markoeltiger/GrandLeague?color=dark-green) ![Forks](https://img.shields.io/github/forks/markoeltiger/GrandLeague?style=social) ![Stargazers](https://img.shields.io/github/stars/markoeltiger/GrandLeague?style=social) ![Issues](https://img.shields.io/github/issues/markoeltiger/GrandLeague) ![License](https://img.shields.io/github/license/markoeltiger/GrandLeague) 

## Table Of Contents

* [About the Project](#about-the-project)
* [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Authors](#authors)
* [Acknowledgements](#acknowledgements)

## About The Project

![Screen Shot](https://xd.adobe.com/view/1fff6bf0-bfa0-48aa-9a84-5ce56317ae74-4aac/screen/e601e8e5-0286-489c-b6e4-3e1c0491682d/specs/)

I build the app to be offline first which loads data from API the inserts it in room database then the view fetches it from the database so the user will always see data which gives better user exprince

Here's how:

* Send request with retrofit to api to get data
* Insert the Fetched data to the Database
* Let the UI fetch the data from Room Database 
* Now user always happy because the app always had data:smile:

 
A list of commonly used resources that I find helpful are listed in the acknowledgements.

## Built With

A GrandLeague application build with\
* [Compose UI](Compose UI)
* [coroutine](coroutine)
* [retrofit](retrofit)
* [MVVM](MVVM)
* [DaggerHilt](DaggerHilt)
* [LiveData](LiveData)
* [Room](Room)

## Getting Started

 

### Prerequisites

-Android Studio
-Java SDK

### Installation

1. Get a free API Key at [https://www.football-data.org/](https://www.football-data.org/)

2. Clone the repo

```sh
git clone https://github.com/markoeltiger/GrandLeague.git
```


3. Enter your API in `Constats.kt`

```KT
    const val API_KEY = "here your api"

```

## Usage

Clone The Project
and open it in your android studio it will be helpful if you want  to add some thing new

## Roadmap

See the [open issues](https://github.com/markoeltiger/GrandLeague/issues) for a list of proposed features (and known issues).

## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.
* If you have suggestions for adding or removing projects, feel free to [open an issue](https://github.com/markoeltiger/GrandLeague/issues/new) to discuss it, or directly create a pull request after you edit the *README.md* file with necessary changes.
* Please make sure you check your spelling and grammar.
* Create individual PR for each suggestion.
* Please also read through the [Code Of Conduct](https://github.com/markoeltiger/GrandLeague/blob/main/CODE_OF_CONDUCT.md) before posting your first idea as well.

### Creating A Pull Request

1. Fork the Project
2. Create your Feature Branch (`git checkout -b`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See [LICENSE](https://github.com/markoeltiger/GrandLeague/blob/main/LICENSE.md) for more information.

## Authors

* **Mark Saif** - *Software Engineer* - [Mark Saif](https://github.com/markoeltiger/) - *Build the project*

 
