import React, {Component} from 'react';
import ReactDom from 'react-dom';
import SearchBar from './components/search_bar';
import VideoList from './components/video_list';
import VideoDetail from './components/video_detail';

import YTSearch from 'youtube-api-search';

// Key for using the YouTube API
const API_KEY = 'AIzaSyBZw4pCiVppYedjTlslY8wK83D3XLXEPJE';

// Main application class
class App extends Component {
    constructor(p) {
        super(p);
        this.state = {videos: []};

// Search youtube.com     
        YTSearch(   {key: API_KEY, term: 'surfboards'},
// Key and property are same name - hence this syntax: {video}
                    (videos) => { this.setState({videos})
            }
        );
    }

    render() {
        return (

            <div>
                // The player is displayed in the original size behind the list
                // if rendered before
                <SearchBar/>
                <VideoList videos={this.state.videos}/>
                <VideoDetail video = {this.state.videos[0]}/>

            </div>
        );
    }
}
//

// Render on the screen   ---
ReactDom.render(<App/>, document.querySelector('.container'))
