<!-- **************************************
	template
*************************************** -->
<template>
    <div>
        <b-container fluid class="col-sm-6 border border-dark p-3" style="border: solid;">
            <b-row class="my-1">
                <b-col sm="3">
                    <label for="bookName">ブック名：</label>
                </b-col>
                <b-col sm="9">
                    {{ bookName }}
                    <b-form-input id="bookName" type="text" v-model="searchInfo.bookName"></b-form-input>
                </b-col>
            </b-row>
            <b-row class="my-1 justify-content-md-right">
                <b-button @click="doSearch" variant="info"><b-icon-search></b-icon-search> 検索</b-button>
            </b-row>
        </b-container>

        <b-container class="justify-content-md-center">
            <b-table :fields="fields" :items="items" selectable select-mode="multi" class="mt-3" bordered="true"
                @row-selected="onRowSelected">
                <template #cell(selected)="{ rowSelected }">
                    <template v-if="rowSelected">
                        <b-icon icon="check-square"></b-icon>
                    </template>
                    <template v-else>
                        <b-icon icon="square"></b-icon>
                    </template>
                </template>
                <template #cell(id)="{ item }">
                    <b-img :src="item.id | thumbnailUrl" @click="playVideo(item.id)" fluid alt="Fluid image"
                        data-toggle="modal" data-target="#image-select-modal"></b-img>
                </template>
            </b-table>
        </b-container>
        <div class="modal fade" id="image-select-modal" @hidden="onHidden">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">ヴィデオ再生</h5>
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div id="modal-body" ref="modal-body" class="modal-body p-0" style="width:100%;overflow:auto;">
                        <iframe width="498" height="432" :src="url" frameborder="0"
                            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                            allowfullscreen></iframe>
                    </div>
                </div>
            </div>
        </div>
        <!-- <div id="container"> -->
        <!-- <div id="exampleModal" class="reveal-modal">
                <h2>POP UP</h2>
                <p>
                    <font size="4">window window window.window window window. window.
                    </font>
                </p>
                <a href="#" class="close-reveal-modal">×</a>
            </div>
        </div> -->
    </div>
</template>
<!-- **************************************
	script
*************************************** -->
<script>
module.exports = {
    props: ['bookName'],
    /* == data == リアクティブ・データ登録 */
    data() {
        return {
            searchInfo: {
                bookName: 'ハムレット'
            },
            fields: [
                { key: 'selected', label: "削除", thStyle: { width: "8%" } },
                { key: 'title', label: "タイトル", thStyle: { width: "42%" } },
                { key: 'id', label: 'URL', thStyle: { width: "50%" } }
            ],
            items: [],
            selected: [],
            playVideoId: '',
            url: '',
        }
    },

    /* == filters == */
    filters: {
        thumbnailUrl(id) {
            return 'https://img.youtube.com/vi/' + id + '/mqdefault.jpg';
        },
    },
    created() {
    },
    methods: {
        doSearch() {
            console.log('Do Search!');
            console.log('bookName: ' + this.bookName + '; searchInfo.bookName: ' + this.searchInfo.bookName);
            var _this = this;
            axios.get('./dat/owls.json').then(function (response) {
                _this.items = response.data;
                console.log(response.data);
            }).catch(function (error) {
                console.log(error);
            });
        },

        onRowSelected(items) {
            this.selected = items;
        },
        playVideo(id) {
            console.log(id);
            this.playVideoId = id;
            this.url = 'https://www.youtube.com/embed/' + id;
            console.log($('div#container'));
            $('div#container').show();
        },
        onHidden() {
            alert('hidden!');
        }
    }
}
</script>
<!-- **************************************
	style
*************************************** -->
<style scoped>
#container {
    width: 100%;
    height: 100%;
    position: absolute;
    visibility: hidden;
    display: none;
    background-color: rgba(22, 22, 22, 0.5);
}

#container:target {
    visibility: visible;
    display: block;
}

.reveal-modal {
    background: #e1e1e1;
    margin: 0 auto;
    /* width: 160px; */
    position: relative;
    z-index: 41;
    top: 25%;
    padding: 30px;
    -webkit-box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);
    -moz-box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);
}
</style>