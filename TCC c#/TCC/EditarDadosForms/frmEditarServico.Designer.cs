namespace TCC.EditarDadosForms
{
    partial class frmEditarServico
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle3 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmEditarServico));
            this.lblMarca = new System.Windows.Forms.Label();
            this.btnVoltar = new System.Windows.Forms.Label();
            this.lblUsuario = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.btnPesquisar = new System.Windows.Forms.Button();
            this.txtIdPrest = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.txtIdNome = new System.Windows.Forms.TextBox();
            this.lblPesquisarNome = new System.Windows.Forms.Label();
            this.lblRedorDireito = new System.Windows.Forms.Label();
            this.btnChangeProfile = new System.Windows.Forms.Label();
            this.btnSair = new System.Windows.Forms.Label();
            this.lblNumeroMensagens = new System.Windows.Forms.Label();
            this.btnMensagens = new System.Windows.Forms.Label();
            this.btnNotas = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.btnEditarPrestador = new System.Windows.Forms.Label();
            this.btnEditarServico = new System.Windows.Forms.Label();
            this.btnEditarAdm = new System.Windows.Forms.Label();
            this.btnEditarUsuario = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.lblRedor = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.txtIdServ = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.txtNomeUsu = new System.Windows.Forms.TextBox();
            this.txtNomePrest = new System.Windows.Forms.TextBox();
            this.txtNomeServ = new System.Windows.Forms.TextBox();
            this.dtDisplay = new System.Windows.Forms.DataGridView();
            this.btnDeletar = new System.Windows.Forms.DataGridViewImageColumn();
            this.txtIDservico = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.txtIDprestserv = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.txtNomeprestserv = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.txtIDusuario = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.txtNomeusuario = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.cbServico = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.txtAvaliacao = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dtDisplay)).BeginInit();
            this.SuspendLayout();
            // 
            // lblMarca
            // 
            this.lblMarca.AutoSize = true;
            this.lblMarca.BackColor = System.Drawing.SystemColors.ControlLight;
            this.lblMarca.Font = new System.Drawing.Font("Kotori Rose", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblMarca.ForeColor = System.Drawing.Color.RoyalBlue;
            this.lblMarca.Location = new System.Drawing.Point(239, 119);
            this.lblMarca.Name = "lblMarca";
            this.lblMarca.Size = new System.Drawing.Size(21, 23);
            this.lblMarca.TabIndex = 88;
            this.lblMarca.Text = "<";
            this.lblMarca.MouseEnter += new System.EventHandler(this.btnEditarServico_MouseEnter);
            this.lblMarca.MouseLeave += new System.EventHandler(this.btnEditarServico_MouseLeave);
            // 
            // btnVoltar
            // 
            this.btnVoltar.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnVoltar.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnVoltar.Image = global::TCC.Properties.Resources.voltar;
            this.btnVoltar.Location = new System.Drawing.Point(99, 488);
            this.btnVoltar.Name = "btnVoltar";
            this.btnVoltar.Size = new System.Drawing.Size(119, 66);
            this.btnVoltar.TabIndex = 87;
            this.btnVoltar.Click += new System.EventHandler(this.btnVoltar_Click);
            this.btnVoltar.Paint += new System.Windows.Forms.PaintEventHandler(this.btnVoltar_Paint);
            // 
            // lblUsuario
            // 
            this.lblUsuario.AutoSize = true;
            this.lblUsuario.BackColor = System.Drawing.Color.Transparent;
            this.lblUsuario.ForeColor = System.Drawing.Color.Black;
            this.lblUsuario.Location = new System.Drawing.Point(962, 68);
            this.lblUsuario.Name = "lblUsuario";
            this.lblUsuario.Size = new System.Drawing.Size(32, 17);
            this.lblUsuario.TabIndex = 86;
            this.lblUsuario.Text = "aaa";
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::TCC.Properties.Resources.imgNomeLogin1;
            this.pictureBox1.Location = new System.Drawing.Point(929, 46);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(179, 63);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox1.TabIndex = 85;
            this.pictureBox1.TabStop = false;
            // 
            // btnPesquisar
            // 
            this.btnPesquisar.Location = new System.Drawing.Point(809, 75);
            this.btnPesquisar.Name = "btnPesquisar";
            this.btnPesquisar.Size = new System.Drawing.Size(92, 61);
            this.btnPesquisar.TabIndex = 84;
            this.btnPesquisar.Text = "Pesquisar";
            this.btnPesquisar.UseVisualStyleBackColor = true;
            this.btnPesquisar.Click += new System.EventHandler(this.btnPesquisar_Click_1);
            // 
            // txtIdPrest
            // 
            this.txtIdPrest.Location = new System.Drawing.Point(519, 94);
            this.txtIdPrest.Name = "txtIdPrest";
            this.txtIdPrest.Size = new System.Drawing.Size(59, 22);
            this.txtIdPrest.TabIndex = 83;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(444, 71);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(61, 17);
            this.label2.TabIndex = 82;
            this.label2.Text = "Usuário:";
            // 
            // txtIdNome
            // 
            this.txtIdNome.Location = new System.Drawing.Point(519, 68);
            this.txtIdNome.Name = "txtIdNome";
            this.txtIdNome.Size = new System.Drawing.Size(59, 22);
            this.txtIdNome.TabIndex = 81;
            // 
            // lblPesquisarNome
            // 
            this.lblPesquisarNome.AutoSize = true;
            this.lblPesquisarNome.Font = new System.Drawing.Font("Microsoft Tai Le", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblPesquisarNome.Location = new System.Drawing.Point(515, 43);
            this.lblPesquisarNome.Name = "lblPesquisarNome";
            this.lblPesquisarNome.Size = new System.Drawing.Size(42, 19);
            this.lblPesquisarNome.TabIndex = 80;
            this.lblPesquisarNome.Text = "- IDs";
            // 
            // lblRedorDireito
            // 
            this.lblRedorDireito.Location = new System.Drawing.Point(313, 23);
            this.lblRedorDireito.Name = "lblRedorDireito";
            this.lblRedorDireito.Size = new System.Drawing.Size(816, 564);
            this.lblRedorDireito.TabIndex = 78;
            this.lblRedorDireito.Paint += new System.Windows.Forms.PaintEventHandler(this.lblRedorDireito_Paint);
            // 
            // btnChangeProfile
            // 
            this.btnChangeProfile.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnChangeProfile.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnChangeProfile.Image = global::TCC.Properties.Resources.trocar_usuario_2;
            this.btnChangeProfile.Location = new System.Drawing.Point(46, 386);
            this.btnChangeProfile.Name = "btnChangeProfile";
            this.btnChangeProfile.Size = new System.Drawing.Size(224, 66);
            this.btnChangeProfile.TabIndex = 76;
            this.btnChangeProfile.Click += new System.EventHandler(this.btnChangeProfile_Click);
            this.btnChangeProfile.Paint += new System.Windows.Forms.PaintEventHandler(this.btnChangeProfile_Paint);
            // 
            // btnSair
            // 
            this.btnSair.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnSair.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSair.Image = global::TCC.Properties.Resources.turn_off_41;
            this.btnSair.Location = new System.Drawing.Point(46, 321);
            this.btnSair.Name = "btnSair";
            this.btnSair.Size = new System.Drawing.Size(224, 66);
            this.btnSair.TabIndex = 75;
            this.btnSair.Paint += new System.Windows.Forms.PaintEventHandler(this.btnSair_Paint);
            // 
            // lblNumeroMensagens
            // 
            this.lblNumeroMensagens.AutoSize = true;
            this.lblNumeroMensagens.BackColor = System.Drawing.SystemColors.ControlLight;
            this.lblNumeroMensagens.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblNumeroMensagens.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.lblNumeroMensagens.Location = new System.Drawing.Point(239, 292);
            this.lblNumeroMensagens.Name = "lblNumeroMensagens";
            this.lblNumeroMensagens.Size = new System.Drawing.Size(18, 20);
            this.lblNumeroMensagens.TabIndex = 74;
            this.lblNumeroMensagens.Text = "0";
            this.lblNumeroMensagens.Click += new System.EventHandler(this.btnMensagens_Click);
            this.lblNumeroMensagens.MouseEnter += new System.EventHandler(this.lblNumeroMensagens_MouseEnter);
            this.lblNumeroMensagens.MouseLeave += new System.EventHandler(this.lblNumeroMensagens_MouseLeave);
            // 
            // btnMensagens
            // 
            this.btnMensagens.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnMensagens.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMensagens.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnMensagens.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnMensagens.Location = new System.Drawing.Point(48, 286);
            this.btnMensagens.Name = "btnMensagens";
            this.btnMensagens.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnMensagens.Size = new System.Drawing.Size(219, 35);
            this.btnMensagens.TabIndex = 73;
            this.btnMensagens.Text = "MENSAGENS";
            this.btnMensagens.Click += new System.EventHandler(this.btnMensagens_Click);
            this.btnMensagens.MouseEnter += new System.EventHandler(this.btnMensagens_MouseEnter);
            this.btnMensagens.MouseLeave += new System.EventHandler(this.btnMensagens_MouseLeave);
            // 
            // btnNotas
            // 
            this.btnNotas.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnNotas.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnNotas.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnNotas.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnNotas.Location = new System.Drawing.Point(48, 251);
            this.btnNotas.Name = "btnNotas";
            this.btnNotas.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnNotas.Size = new System.Drawing.Size(219, 35);
            this.btnNotas.TabIndex = 72;
            this.btnNotas.Text = "NOTAS";
            this.btnNotas.Click += new System.EventHandler(this.btnNotas_Click);
            this.btnNotas.MouseEnter += new System.EventHandler(this.btnNotas_MouseEnter);
            this.btnNotas.MouseLeave += new System.EventHandler(this.btnNotas_MouseLeave);
            // 
            // label6
            // 
            this.label6.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label6.Font = new System.Drawing.Font("Leelawadee UI", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(46, 218);
            this.label6.Name = "label6";
            this.label6.Padding = new System.Windows.Forms.Padding(8, 3, 0, 0);
            this.label6.Size = new System.Drawing.Size(224, 33);
            this.label6.TabIndex = 71;
            this.label6.Text = "MENSAGENS";
            // 
            // btnEditarPrestador
            // 
            this.btnEditarPrestador.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnEditarPrestador.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnEditarPrestador.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditarPrestador.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnEditarPrestador.Location = new System.Drawing.Point(48, 148);
            this.btnEditarPrestador.Name = "btnEditarPrestador";
            this.btnEditarPrestador.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnEditarPrestador.Size = new System.Drawing.Size(219, 35);
            this.btnEditarPrestador.TabIndex = 70;
            this.btnEditarPrestador.Text = "EDITAR PRESTADOR";
            this.btnEditarPrestador.Click += new System.EventHandler(this.btnEditarPrestador_Click);
            this.btnEditarPrestador.MouseEnter += new System.EventHandler(this.btnEditarPrestador_MouseEnter);
            this.btnEditarPrestador.MouseLeave += new System.EventHandler(this.btnEditarPrestador_MouseLeave);
            // 
            // btnEditarServico
            // 
            this.btnEditarServico.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnEditarServico.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnEditarServico.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditarServico.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnEditarServico.Location = new System.Drawing.Point(48, 113);
            this.btnEditarServico.Name = "btnEditarServico";
            this.btnEditarServico.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnEditarServico.Size = new System.Drawing.Size(219, 35);
            this.btnEditarServico.TabIndex = 69;
            this.btnEditarServico.Text = "EDITAR SERVIÇO";
            this.btnEditarServico.MouseEnter += new System.EventHandler(this.btnEditarServico_MouseEnter);
            this.btnEditarServico.MouseLeave += new System.EventHandler(this.btnEditarServico_MouseLeave);
            // 
            // btnEditarAdm
            // 
            this.btnEditarAdm.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnEditarAdm.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnEditarAdm.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditarAdm.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnEditarAdm.Location = new System.Drawing.Point(48, 183);
            this.btnEditarAdm.Name = "btnEditarAdm";
            this.btnEditarAdm.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnEditarAdm.Size = new System.Drawing.Size(219, 35);
            this.btnEditarAdm.TabIndex = 68;
            this.btnEditarAdm.Text = "EDITAR ADM";
            this.btnEditarAdm.Click += new System.EventHandler(this.btnEditarAdm_Click);
            this.btnEditarAdm.MouseEnter += new System.EventHandler(this.btnEditarAdm_MouseEnter);
            this.btnEditarAdm.MouseLeave += new System.EventHandler(this.btnEditarAdm_MouseLeave);
            // 
            // btnEditarUsuario
            // 
            this.btnEditarUsuario.BackColor = System.Drawing.SystemColors.ControlLight;
            this.btnEditarUsuario.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnEditarUsuario.Font = new System.Drawing.Font("Kotori Rose", 8.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEditarUsuario.ForeColor = System.Drawing.SystemColors.HotTrack;
            this.btnEditarUsuario.Location = new System.Drawing.Point(48, 78);
            this.btnEditarUsuario.Name = "btnEditarUsuario";
            this.btnEditarUsuario.Padding = new System.Windows.Forms.Padding(8, 9, 0, 0);
            this.btnEditarUsuario.Size = new System.Drawing.Size(219, 35);
            this.btnEditarUsuario.TabIndex = 67;
            this.btnEditarUsuario.Text = "EDITAR USUÁRIO";
            this.btnEditarUsuario.Click += new System.EventHandler(this.btnEditarUsuario_Click);
            this.btnEditarUsuario.MouseEnter += new System.EventHandler(this.btnEditarUsuario_MouseEnter);
            this.btnEditarUsuario.MouseLeave += new System.EventHandler(this.btnEditarUsuario_MouseLeave);
            // 
            // label1
            // 
            this.label1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label1.Font = new System.Drawing.Font("Leelawadee UI", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(46, 45);
            this.label1.Name = "label1";
            this.label1.Padding = new System.Windows.Forms.Padding(8, 3, 0, 0);
            this.label1.Size = new System.Drawing.Size(224, 33);
            this.label1.TabIndex = 66;
            this.label1.Text = "EDIÇÃO";
            // 
            // lblRedor
            // 
            this.lblRedor.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.lblRedor.Location = new System.Drawing.Point(26, 24);
            this.lblRedor.Name = "lblRedor";
            this.lblRedor.Size = new System.Drawing.Size(264, 564);
            this.lblRedor.TabIndex = 77;
            this.lblRedor.Paint += new System.Windows.Forms.PaintEventHandler(this.lblRedor_Paint);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Gilroy ExtraBold", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(329, 35);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(107, 25);
            this.label3.TabIndex = 89;
            this.label3.Text = "Pesquisar:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(444, 97);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(74, 17);
            this.label4.TabIndex = 90;
            this.label4.Text = "Prestador:";
            // 
            // txtIdServ
            // 
            this.txtIdServ.Location = new System.Drawing.Point(519, 120);
            this.txtIdServ.Name = "txtIdServ";
            this.txtIdServ.Size = new System.Drawing.Size(59, 22);
            this.txtIdServ.TabIndex = 91;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(444, 123);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(59, 17);
            this.label5.TabIndex = 92;
            this.label5.Text = "Serviço:";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Tai Le", 9F, System.Drawing.FontStyle.Bold);
            this.label7.Location = new System.Drawing.Point(587, 43);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(73, 19);
            this.label7.TabIndex = 93;
            this.label7.Text = "- Nomes:";
            // 
            // txtNomeUsu
            // 
            this.txtNomeUsu.Location = new System.Drawing.Point(591, 68);
            this.txtNomeUsu.Name = "txtNomeUsu";
            this.txtNomeUsu.Size = new System.Drawing.Size(212, 22);
            this.txtNomeUsu.TabIndex = 94;
            // 
            // txtNomePrest
            // 
            this.txtNomePrest.Location = new System.Drawing.Point(591, 94);
            this.txtNomePrest.Name = "txtNomePrest";
            this.txtNomePrest.Size = new System.Drawing.Size(212, 22);
            this.txtNomePrest.TabIndex = 95;
            // 
            // txtNomeServ
            // 
            this.txtNomeServ.Enabled = false;
            this.txtNomeServ.Location = new System.Drawing.Point(591, 120);
            this.txtNomeServ.Name = "txtNomeServ";
            this.txtNomeServ.Size = new System.Drawing.Size(212, 22);
            this.txtNomeServ.TabIndex = 96;
            // 
            // dtDisplay
            // 
            this.dtDisplay.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dtDisplay.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.btnDeletar,
            this.txtIDservico,
            this.txtIDprestserv,
            this.txtNomeprestserv,
            this.txtIDusuario,
            this.txtNomeusuario,
            this.cbServico,
            this.txtAvaliacao});
            this.dtDisplay.Location = new System.Drawing.Point(332, 162);
            this.dtDisplay.Name = "dtDisplay";
            dataGridViewCellStyle2.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle2.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle2.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle2.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle2.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle2.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle2.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dtDisplay.RowHeadersDefaultCellStyle = dataGridViewCellStyle2;
            this.dtDisplay.RowHeadersWidth = 51;
            dataGridViewCellStyle3.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            this.dtDisplay.RowsDefaultCellStyle = dataGridViewCellStyle3;
            this.dtDisplay.RowTemplate.Height = 30;
            this.dtDisplay.Size = new System.Drawing.Size(776, 409);
            this.dtDisplay.TabIndex = 79;
            this.dtDisplay.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dtDisplay_CellClick);
            this.dtDisplay.CellValueChanged += new System.Windows.Forms.DataGridViewCellEventHandler(this.dtDisplay_CellValueChanged);
            // 
            // btnDeletar
            // 
            dataGridViewCellStyle1.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleCenter;
            dataGridViewCellStyle1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(102)))), ((int)(((byte)(204)))));
            dataGridViewCellStyle1.Font = new System.Drawing.Font("Gilroy ExtraBold", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle1.ForeColor = System.Drawing.Color.Transparent;
            dataGridViewCellStyle1.NullValue = ((object)(resources.GetObject("dataGridViewCellStyle1.NullValue")));
            dataGridViewCellStyle1.SelectionBackColor = System.Drawing.Color.FromArgb(((int)(((byte)(0)))), ((int)(((byte)(102)))), ((int)(((byte)(204)))));
            dataGridViewCellStyle1.SelectionForeColor = System.Drawing.Color.White;
            this.btnDeletar.DefaultCellStyle = dataGridViewCellStyle1;
            this.btnDeletar.HeaderText = "";
            this.btnDeletar.Image = global::TCC.Properties.Resources.lixo;
            this.btnDeletar.ImageLayout = System.Windows.Forms.DataGridViewImageCellLayout.Zoom;
            this.btnDeletar.MinimumWidth = 6;
            this.btnDeletar.Name = "btnDeletar";
            this.btnDeletar.ReadOnly = true;
            this.btnDeletar.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.btnDeletar.Width = 30;
            // 
            // txtIDservico
            // 
            this.txtIDservico.DataPropertyName = "id_servico";
            this.txtIDservico.HeaderText = "ID Serviço";
            this.txtIDservico.MinimumWidth = 6;
            this.txtIDservico.Name = "txtIDservico";
            this.txtIDservico.Width = 80;
            // 
            // txtIDprestserv
            // 
            this.txtIDprestserv.DataPropertyName = "id_prestservF";
            this.txtIDprestserv.HeaderText = "ID Prestador";
            this.txtIDprestserv.MinimumWidth = 6;
            this.txtIDprestserv.Name = "txtIDprestserv";
            this.txtIDprestserv.Width = 80;
            // 
            // txtNomeprestserv
            // 
            this.txtNomeprestserv.DataPropertyName = "nome_prestserv";
            this.txtNomeprestserv.HeaderText = "Nome Prestador";
            this.txtNomeprestserv.MinimumWidth = 6;
            this.txtNomeprestserv.Name = "txtNomeprestserv";
            this.txtNomeprestserv.Width = 125;
            // 
            // txtIDusuario
            // 
            this.txtIDusuario.DataPropertyName = "id_usuF";
            this.txtIDusuario.HeaderText = "ID Usuário";
            this.txtIDusuario.MinimumWidth = 6;
            this.txtIDusuario.Name = "txtIDusuario";
            this.txtIDusuario.Width = 80;
            // 
            // txtNomeusuario
            // 
            this.txtNomeusuario.DataPropertyName = "nome_usu";
            this.txtNomeusuario.HeaderText = "Nome Usuário";
            this.txtNomeusuario.MinimumWidth = 6;
            this.txtNomeusuario.Name = "txtNomeusuario";
            this.txtNomeusuario.Width = 125;
            // 
            // cbServico
            // 
            this.cbServico.DataPropertyName = "tipo_serv";
            this.cbServico.HeaderText = "Serviço";
            this.cbServico.MinimumWidth = 6;
            this.cbServico.Name = "cbServico";
            this.cbServico.ReadOnly = true;
            this.cbServico.Resizable = System.Windows.Forms.DataGridViewTriState.False;
            this.cbServico.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.NotSortable;
            this.cbServico.Width = 125;
            // 
            // txtAvaliacao
            // 
            this.txtAvaliacao.DataPropertyName = "avaliacao";
            this.txtAvaliacao.HeaderText = "Avaliação";
            this.txtAvaliacao.MinimumWidth = 6;
            this.txtAvaliacao.Name = "txtAvaliacao";
            this.txtAvaliacao.Width = 125;
            // 
            // frmEditarServico
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.ClientSize = new System.Drawing.Size(1155, 612);
            this.Controls.Add(this.txtNomeServ);
            this.Controls.Add(this.txtNomePrest);
            this.Controls.Add(this.txtNomeUsu);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.txtIdServ);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.lblMarca);
            this.Controls.Add(this.btnVoltar);
            this.Controls.Add(this.lblUsuario);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.btnPesquisar);
            this.Controls.Add(this.txtIdPrest);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtIdNome);
            this.Controls.Add(this.lblPesquisarNome);
            this.Controls.Add(this.dtDisplay);
            this.Controls.Add(this.lblRedorDireito);
            this.Controls.Add(this.btnChangeProfile);
            this.Controls.Add(this.btnSair);
            this.Controls.Add(this.lblNumeroMensagens);
            this.Controls.Add(this.btnMensagens);
            this.Controls.Add(this.btnNotas);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.btnEditarPrestador);
            this.Controls.Add(this.btnEditarServico);
            this.Controls.Add(this.btnEditarAdm);
            this.Controls.Add(this.btnEditarUsuario);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lblRedor);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "frmEditarServico";
            this.Text = "Editar serviço";
            this.Load += new System.EventHandler(this.frmEditarServico_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dtDisplay)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblMarca;
        private System.Windows.Forms.Label btnVoltar;
        private System.Windows.Forms.Label lblUsuario;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Button btnPesquisar;
        private System.Windows.Forms.TextBox txtIdPrest;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtIdNome;
        private System.Windows.Forms.Label lblPesquisarNome;
        private System.Windows.Forms.Label lblRedorDireito;
        private System.Windows.Forms.Label btnChangeProfile;
        private System.Windows.Forms.Label btnSair;
        private System.Windows.Forms.Label lblNumeroMensagens;
        private System.Windows.Forms.Label btnMensagens;
        private System.Windows.Forms.Label btnNotas;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label btnEditarPrestador;
        private System.Windows.Forms.Label btnEditarServico;
        private System.Windows.Forms.Label btnEditarAdm;
        private System.Windows.Forms.Label btnEditarUsuario;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblRedor;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtIdServ;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox txtNomeUsu;
        private System.Windows.Forms.TextBox txtNomePrest;
        private System.Windows.Forms.TextBox txtNomeServ;
        private System.Windows.Forms.DataGridView dtDisplay;
        private System.Windows.Forms.DataGridViewImageColumn btnDeletar;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtIDservico;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtIDprestserv;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtNomeprestserv;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtIDusuario;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtNomeusuario;
        private System.Windows.Forms.DataGridViewTextBoxColumn cbServico;
        private System.Windows.Forms.DataGridViewTextBoxColumn txtAvaliacao;
    }
}